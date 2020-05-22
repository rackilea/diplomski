public static void main(String[] args) {
    int v = 2;
    int[] in = new int[]{1, 2, 3, 4, 5};

    List<Integer> list = new ArrayList<>();
    for(int i: in) {
        if (i!=v) {
            list.add(i);
        }
    }

    Integer[] result = list.toArray(new Integer[]{});
}