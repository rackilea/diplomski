public static void main(String[] args) throws Exception {
    List<JustFive> jfs = Arrays.asList(getInstance(), getInstance(), getInstance(), getInstance(), getInstance());
    Collections.sort(jfs, new Comparator<JustFive>(){
        @Override
        public int compare(JustFive o1, JustFive o2) {
            return -1 * new Integer(o1.id).compareTo(o2.getId());
        }
    });
    for (JustFive justFive : jfs) {
        System.out.println(justFive.getId());
    }
}