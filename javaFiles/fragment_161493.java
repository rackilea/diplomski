public static void main(String[] args) {
    String[] s = "1 2 3 -4 -5 -6 -7 -8 -9".split(" ");
    Arrays.asList(s).stream().limit(5).forEach(System.out::print); // filter
   // or use below to get the first five element list
   Arrays.asList(s).stream().limit(5).collect(Collectors.toList());
}