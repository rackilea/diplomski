public static void permuteSubsequence(String s) {
    int[] permutable = IntStream.range(0, s.length())
        .filter(i->Character.toLowerCase(s.charAt(i))!=Character.toUpperCase(s.charAt(i)))
        .toArray();
    if(permutable.length == 0) {
        System.out.println(s);
        return;
    }
    String lower = s.toLowerCase(), upper = s.toUpperCase();
    if(s.length()!=lower.length() || s.length()!=upper.length())
        throw new UnsupportedOperationException("non trivial case mapping");
    LongStream.range(0, 1L<<Math.min(permutable.length, 62))
        .mapToObj(l -> {
            StringBuilder sb=new StringBuilder(lower);
            BitSet.valueOf(new long[] { l }).stream()
                  .map(bit -> permutable[bit])
                  .forEach(ix -> sb.setCharAt(ix, upper.charAt(ix)));
            return sb.toString();
        })
        .forEach(System.out::println);
}