public static void main(String[] args) {
    final int [] temp = {56, 45, 67, 41, 59, 70};

    Integer [] index = new Integer[temp.length];
    for (int i = 0; i < index.length; i++) {
        index[i] = i;
    }

    Arrays.sort(index, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return temp[a] - temp[b];
        }
    });

    for (Integer i : index) {
        System.out.printf("temp %d on day %d%n", temp[i], i);
    }

}