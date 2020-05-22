final Integer[] searchList = new Integer[] { 5, 2, 3, 8, 0, 1 };
    Arrays.sort(searchList, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 == 0) {
                return 1;
            }
            if (o2 == 0) {
                return -1;
            }
            return o1.compareTo(o2);
        }
    });