package mydatastore.collections.concurrent;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @date 19.10.2012
 * @author Thomas Jahoda
 */
public class SecureArrayList_Test {

    private static SecureArrayList<String> statList = new SecureArrayList<>();

    public static void main(String[] args) {
        accessExamples();
//        mechanismTest_1();
//        mechanismTest_2();
    }

    private static void accessExamples() {
        final SecureArrayList<String> list = getList();
        //
        try {
            list.lockWrite();
            //
            list.add("banana");
            list.add("test");
        } finally {
            list.unlockWrite();
        }
        ////// independent single statement reading or writing access
        String val = list.get(0);
        //// ---

        ////// reading only block (just some senseless unoptimized 'whatever' example)
        int lastIndex = -1;
        try {
            list.lockRead();
            //
            String search = "test";
            if (list.contains(search)) {
                lastIndex = list.lastIndexOf(search);
            }
            // !!! MIND !!!
            // inserting writing operations here results in a DEADLOCK!!!
            // ... which is just really, really awkward...
        } finally {
            list.unlockRead();
        }
        //// ---

        ////// writing block (can also contain reading operations!!)
        try {
            list.lockWrite();
            //
            int index = list.indexOf("test");
            if (index != -1) {
                String newVal = "banana";
                list.add(index + 1, newVal);
            }
        } finally {
            list.unlockWrite();
        }
        //// ---

        ////// iteration for reading only
        System.out.println("First output: ");
        try {
            list.lockRead();
            //
            for (Iterator<String> it = list.iterator(); it.hasNext();) {
                String string = it.next();
                System.out.println(string);
                // !!! MIND !!!
                // inserting writing operations called directly on the list will result in a deadlock!
                // inserting writing operations called on the iterator will result in an IllegalMonitorStateException!
            }
        } finally {
            list.unlockRead();
        }
        System.out.println("------");
        //// ---

        ////// iteration for writing and reading
        try {
            list.lockWrite();
            //
            boolean firstAdd = true;
            for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
                int index = it.nextIndex();
                String string = it.next();
                switch (string) {
                    case "banana":
                        it.remove();
                        break;
                    case "test":
                        if (firstAdd) {
                            it.add("whatever");
                            firstAdd = false;
                        }
                        break;
                }
                if (index == 2) {
                    list.set(index - 1, "pretty senseless data and operations but just to show "
                            + "what's possible");
                }
                // !!! MIND !!!
                // Only I implemented the iterators to enable direct list editing,
                // other implementations normally throw a ConcurrentModificationException
            }
        } finally {
            list.unlockWrite();
        }
        //// ---

        System.out.println("Complete last output: ");
        try {
            list.lockRead();
            //
            for (String string : list) {
                System.out.println(string);
            }
        } finally {
            list.unlockRead();
        }
        System.out.println("------");


        ////// getting the last element
        String lastElement = null;
        try {
            list.lockRead();
            int size = list.size();
            lastElement = list.get(size - 1);
        } finally {
            list.unlockRead();
        }
        System.out.println("Last element: " + lastElement);
        //// ---
    }

    private static void mechanismTest_1() { // fus, roh
        SecureArrayList<String> list = getList();
        try {
            System.out.print("fus, ");
            list.lockRead();
            System.out.print("roh, ");
            list.lockWrite();
            System.out.println("dah!"); // never happens cos of deadlock
        } finally {
            // also never happens
            System.out.println("dah?");
            list.unlockRead();
            list.unlockWrite();
        }
    }

    private static void mechanismTest_2() { // fus, roh, dah!
        SecureArrayList<String> list = getList();
        try {
            System.out.print("fus, ");
            list.lockWrite();
            System.out.print("roh, ");
            list.lockRead();
            System.out.println("dah!");
        } finally {
            list.unlockRead();
            list.unlockWrite();
        }
        // successful execution
    }

    private static SecureArrayList<String> getList() {
        return statList;
    }
}