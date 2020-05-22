List<String> list = Arrays.asList("xx/xx/xxyy/ZZZ","x/x","/x/x/x/xxx");

list.forEach(x -> {
    String[] data = x.split("(?<=[^/\\n].)/|/(?=.[^/\\n])");
    System.out.println(x + " --> " + Arrays.toString(data));
});