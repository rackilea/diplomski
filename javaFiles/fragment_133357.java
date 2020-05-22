Set<String> myStrings = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            // Define comparing logic here
            return o1.compareTo(o2);
        }
    });