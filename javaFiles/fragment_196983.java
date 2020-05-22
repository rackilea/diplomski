public static void main(String[] args) { 
    HashMap<String, String> codes = new HashMap<>();
    codes.put("foo", "201, 202, 203");
    codes.put("bar", "[202, 220]");
    codes.put("baz", "2**");
    codes.put("doo", "[200, 205], 22*");
    codes.put("woo", "200, 201, 202, 203,[209, 214], 29*");

    Set<String[]> set = getSuccessCodes(codes);
    set.forEach(s -> {System.out.println(Arrays.toString(s));});
}