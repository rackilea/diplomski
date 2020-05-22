public int[] getNumbers(int start, int end, int increment) {
    List<Integer> values = new ArrayList<>(); 
    for (int i = start; i < end; i += increment) {
        values.add(i);
    }
    return values.stream().mapToInt(i->i).toArray();
}