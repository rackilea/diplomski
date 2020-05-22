Collections.max(myList, new Comparator<String>() {

        @Override
        public int compare(String lhs, String rhs) {
            String[] first = lhs.split("\\.");
            String[] second = rhs.split("\\.");
            for (int i = 0; i < first.length; i++) {
                if(Integer.valueOf(first[i]) > Integer.valueOf(second[i])) {
                    return 1;
                }
                if(Integer.valueOf(first[i]) < Integer.valueOf(second[i])) {
                    return -1;
                }
            }
            return 0;
        }
    });