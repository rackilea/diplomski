int idx = Arrays.binarySearch(data, 0, data.length - 1, x, 
    Comparator.nullsLast(new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) o1) - ((Integer) o2);
        }
    }));