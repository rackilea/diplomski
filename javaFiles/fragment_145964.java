package WildWezyrListRemovalTesting;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemoveManyFromList {

    public static abstract class BaseRemoveManyPerformer {

        protected String performerName() {
            return getClass().getSimpleName();
        }

        protected void info(String msg) {
            System.out.println(performerName() + ": " + msg);
        }

        protected void populateList(List<Integer> items, int itemCnt) {
            for (int i = 0; i < itemCnt; i++) {
                items.add(i);
            }
        }

        protected boolean mustRemoveItem(Integer itemVal, int itemIdx, int removeFactor) {
            if (removeFactor == 0) {
                return false;
            }
            return itemIdx % removeFactor == 0;
        }

        protected abstract List<Integer> removeItems(List<Integer> items, int removeFactor);

        protected abstract List<Integer> createInitialList();

        public void testMe(int itemCnt, int removeFactor) {
            List<Integer> items = createInitialList();
            populateList(items, itemCnt);
            long startMillis = System.currentTimeMillis();
            items = removeItems(items, removeFactor);
            long endMillis = System.currentTimeMillis();
            int chksum = 0;
            for (Integer item : items) {
                chksum += item;
            }
            info("removing took " + (endMillis - startMillis)
                    + " milli(s), itemCnt=" + itemCnt
                    + ", removed items: " + (itemCnt - items.size())
                    + ", remaining items: " + items.size()
                    + ", checksum: " + chksum);
        }
    }
    private List<BaseRemoveManyPerformer> rmps =
            new ArrayList<BaseRemoveManyPerformer>();

    public void addPerformer(BaseRemoveManyPerformer rmp) {
        rmps.add(rmp);
    }
    private Runtime runtime = Runtime.getRuntime();

    private void runGc() {
        for (int i = 0; i < 5; i++) {
            runtime.gc();
        }
    }

    public void testAll(int itemCnt, int removeFactor) {
        runGc();
        for (BaseRemoveManyPerformer rmp : rmps) {
            rmp.testMe(itemCnt, removeFactor);
        }
        runGc();
        System.out.println("\n--------------------------\n");
    }

    public static class NaiveRemoveManyPerformer
            extends BaseRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
            if (items.size() > 300000 && items instanceof ArrayList) {
                info("this removeItems is too slow, returning without processing");
                return items;
            }
            int i = 0;
            Iterator<Integer> iter = items.iterator();
            while (iter.hasNext()) {
                Integer item = iter.next();
                if (mustRemoveItem(item, i, removeFactor)) {
                    iter.remove();
                }
                i++;
            }
            return items;
        }

        @Override
        public List<Integer> createInitialList() {
            return new ArrayList<Integer>();
        }
    }

    public static class BetterNaiveRemoveManyPerformer
            extends NaiveRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
//            if (items.size() > 300000 && items instanceof ArrayList) {
//                info("this removeItems is too slow, returning without processing");
//                return items;
//            }

            for (int i = items.size(); --i >= 0;) {
                Integer item = items.get(i);
                if (mustRemoveItem(item, i, removeFactor)) {
                    items.remove(i);
                }
            }
            return items;
        }
    }

    public static class LinkedRemoveManyPerformer
            extends NaiveRemoveManyPerformer {

        @Override
        public List<Integer> createInitialList() {
            return new LinkedList<Integer>();
        }
    }

    public static class CreateNewRemoveManyPerformer
            extends NaiveRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
            List<Integer> res = createResultList(items, removeFactor);
            int i = 0;

            for (Integer item : items) {
                if (mustRemoveItem(item, i, removeFactor)) {
                    // no-op
                } else {
                    res.add(item);
                }
                i++;
            }

            return res;
        }

        protected List<Integer> createResultList(List<Integer> items, int removeFactor) {
            return new ArrayList<Integer>();
        }
    }

    public static class SmartCreateNewRemoveManyPerformer
            extends CreateNewRemoveManyPerformer {

        @Override
        protected List<Integer> createResultList(List<Integer> items, int removeFactor) {
            int newCapacity = removeFactor == 0 ? items.size()
                    : (int) (items.size() * (removeFactor - 1L) / removeFactor + 1);
            //System.out.println("newCapacity=" + newCapacity);
            return new ArrayList<Integer>(newCapacity);
        }
    }

    public static class FasterSmartCreateNewRemoveManyPerformer
            extends SmartCreateNewRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
            List<Integer> res = createResultList(items, removeFactor);

            for (int i = 0; i < items.size(); i++) {
                Integer item = items.get(i);
                if (mustRemoveItem(item, i, removeFactor)) {
                    // no-op
                } else {
                    res.add(item);
                }
            }

            return res;
        }
    }

    public static class ForwardInPlaceRemoveManyPerformer
            extends NaiveRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
            int j = 0; // destination idx
            for (int i = 0; i < items.size(); i++) {
                Integer item = items.get(i);
                if (mustRemoveItem(item, i, removeFactor)) {
                    // no-op
                } else {
                    if (j < i) {
                        items.set(j, item);
                    }
                    j++;
                }
            }

            return items.subList(0, j);
        }
    }

    public static class MagicRemoveManyPerformer
            extends NaiveRemoveManyPerformer {

        @Override
        public List<Integer> removeItems(List<Integer> items, int removeFactor) {
            for (int i = 0; i < items.size(); i++) {
                if (mustRemoveItem(items.get(i), i, removeFactor)) {
                    Integer retainedItem = removeSomeFromEnd(items, removeFactor, i);
                    if (retainedItem == null) {
                        items.remove(i);
                        break;
                    }
                    items.set(i, retainedItem);
                }
            }

            return items;
        }

        private Integer removeSomeFromEnd(List<Integer> items, int removeFactor, int lowerBound) {
            for (int i = items.size(); --i > lowerBound;) {
                Integer item = items.get(i);
                items.remove(i);
                if (!mustRemoveItem(item, i, removeFactor)) {
                    return item;
                }
            }
            return null;
        }
    }

    public static class GuavaArrayListRemoveManyPerformer
            extends BaseRemoveManyPerformer {

        @Override
        protected List<Integer> removeItems(List<Integer> items, final int removeFactor) {
            Iterables.removeIf(items, new Predicate<Integer>() {

                public boolean apply(Integer input) {
                    return mustRemoveItem(input, input, removeFactor);
                }
            });

            return items;
        }

        @Override
        protected List<Integer> createInitialList() {
            return new ArrayList<Integer>();
        }
    }

    public void testForOneItemCnt(int itemCnt) {
        testAll(itemCnt, 0);
        testAll(itemCnt, itemCnt);
        testAll(itemCnt, itemCnt - 1);
        testAll(itemCnt, 3);
        testAll(itemCnt, 2);
        testAll(itemCnt, 1);
    }

    public static void main(String[] args) {
        RemoveManyFromList t = new RemoveManyFromList();
        t.addPerformer(new NaiveRemoveManyPerformer());
        t.addPerformer(new BetterNaiveRemoveManyPerformer());
        t.addPerformer(new LinkedRemoveManyPerformer());
        t.addPerformer(new CreateNewRemoveManyPerformer());
        t.addPerformer(new SmartCreateNewRemoveManyPerformer());
        t.addPerformer(new FasterSmartCreateNewRemoveManyPerformer());
        t.addPerformer(new MagicRemoveManyPerformer());
        t.addPerformer(new ForwardInPlaceRemoveManyPerformer());
        t.addPerformer(new GuavaArrayListRemoveManyPerformer());

        t.testForOneItemCnt(1000);
        t.testForOneItemCnt(10000);
        t.testForOneItemCnt(100000);
        t.testForOneItemCnt(200000);
        t.testForOneItemCnt(300000);
        t.testForOneItemCnt(500000);
        t.testForOneItemCnt(1000000);
        t.testForOneItemCnt(10000000);
    }
}