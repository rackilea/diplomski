public static void main(String[] args) {
    List<String> values = Arrays.asList("A", "B", "C");
    /*
     * You obviously want to output 2 values per iteration,
     * that means you have to adjust the condition to iterate to the
     * second last index (because of accessing i + 1)
     */
    for (int i = 0; i < values.size() - 1; i++) {
        System.out.println(values.get(i) + ", " + values.get(i + 1));
    }
}