public void test() {
    String[] x = new String[1];
    List<String> list = Arrays.asList("a", "b", "c", "d");

    list.forEach(n -> {
        if (n.equals("d"))
            x[0] = "match the value";
    });
}