Integer[] indices = new Integer[item.length];
for (int i = 0; i < indices.length; i++) {
    indices[i] = i;
}

Arrays.sort(indices, new Comparator<Integer>() {

    public int compare(Integer i1, Integer i2) {
        return item[i1].compareTo(item[i2]);
    }
});