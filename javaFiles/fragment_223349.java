static void showProducts(int[] list, int product) {
    Set<Integer> hset = new HashSet<Integer>();
    int pairedNum = 0;
    for (int element : list) {
        if (product % element == 0) {
            pairedNum = product / element;
            if (hset.contains (pairedNum)) {
                System.out.println (element + "*" + pairedNum);
            }
            hset.add(element);
        }
    }
}