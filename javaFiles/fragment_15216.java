public static void permuteSubsequence(String s) {
    if(s.isEmpty()) {
        System.out.println();
        return;
    }
    String lower = s.toLowerCase(), upper = s.toUpperCase();
    if(s.length()!=lower.length() || s.length()!=upper.length())
        throw new UnsupportedOperationException("non trivial case mapping");
    LongStream.range(0, 1L<<Math.min(lower.length(), 62))
        .mapToObj(l -> {
            StringBuilder sb=new StringBuilder(lower);
            BitSet.valueOf(new long[] { l }).stream()
                  .forEach(ix -> sb.setCharAt(ix, upper.charAt(ix)));
            return sb.toString();
        })
        .forEach(System.out::println);
}