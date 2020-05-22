private String method(String input) {
    char[] array = input.toCharArray();
    Arrays.sort(array);
    StringBuilder sb = new StringBuilder();
    for(int ix = 0, e; ix<array.length; ix = e) {
        char c = array[ix];
        for(e = ix+1; e<array.length && array[e]==c; ) e++;
        sb.append(c).append(e-ix);
    }
    return sb.toString();
}