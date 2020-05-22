Arrays.sort(strengths, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return Float.compare(Float.valueOf(o1.split(" ")[0]), Float.valueOf(o2.split(" ")[0]));
        }
    });