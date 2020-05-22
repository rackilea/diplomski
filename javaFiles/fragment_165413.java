public String largestNumber(int[] num) {
    String s=Arrays.stream(num).mapToObj(Integer::toString)
                   .sorted((n1, n2) -> (n2+n1).compareTo(n1+n2))
                   .collect(Collectors.joining());
    return s.charAt(0) == '0'? "0": s;
}