public class MyList extends ArrayList<String> {

        @Override
        public boolean add(String item) {
            boolean added = super.add(item);
            if (added && size() >= 10) {
                throw MaxItemsReachedException();
            }
        }

    }