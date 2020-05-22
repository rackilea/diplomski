static void test () {
    List<Object[]> lFiles = new ArrayList<>();

    Collections.sort(lFiles , new Comparator<Object[]>() {
        @Override
        public int compare(Object[] o1, Object[] o2) {
            // Write the logic how two array will compare. 
            return 0;
        }
    });
}