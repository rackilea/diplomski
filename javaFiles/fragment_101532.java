class MyComparator implements Comparator<String> {

        private final String keyWord;

        MyComparator(String keyWord) {
            this.keyWord = keyWord;
        }

        @Override
        public int compare(String o1, String o2) {

            if(o1.startsWith(keyWord)) {
                return o2.startsWith(keyWord)? o1.compareTo(o2): -1;
            } else {
                return o2.startsWith(keyWord)? 1: o1.compareTo(o2); 
            }
        }
    }