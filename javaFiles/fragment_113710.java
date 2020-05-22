new Comparator<String>(){

        @Override
        public int compare(String o1, String o2) {
            int cmp = Integer.compare(o2.length(), o1.length());
            return cmp != 0 ? cmp : o1.compareTo(o2);
        }
    }