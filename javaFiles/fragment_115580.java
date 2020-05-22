final Long[] values = { 1, 3, 2, 5, 4, 2};
Integer[] indices = new Integer[values.length];
for (int i = 0; i < indices.length; i++) {
    indices[i] = i;
}
Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer arg0, Integer arg1) {
        return values[arg0].compareTo(values[arg1]);
    }
};
Arrays.sort(indices, comparator);
System.out.println(Arrays.toString(indices));