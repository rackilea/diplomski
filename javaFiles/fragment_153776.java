String[] strs = {"1234567", "12345678"};
for (String str : strs) {
    String path = Arrays.stream(str.split("(?<=\\G.{2})"))
            .filter(s -> s.length() == 2)
            .collect(Collectors.joining("//"))
            .concat("//")
            .concat(str)
            .concat(".jpg");
    System.out.println(path);
}