public static void generateCombinationsIterative(List<Integer> original, int fnum, int snum) {
    int size = original.size();
    for (int i=0 ; i<=size ; i++) {
        List<Integer> tmp = new ArrayList<>(original);
        tmp.add(i,fnum);
        for (int j=0 ; j<=size + 1 ; j++) {
            tmp.add(j,snum);
            System.out.print(tmp + (i == size && j == size + 1 ? "" : ", "));
            tmp.remove(j);
        }
    }
}