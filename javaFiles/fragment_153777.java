String[] strs = {"12.jpg", "123.jpg", "123456.jpg"};
for (String str : strs) {
    String path = Arrays.stream(str.substring(0, str.indexOf(".")).split("(?<=\\G.{2})"))
            .filter(s -> s.length() == 2)
            .collect(Collectors.joining("//"))
            .concat("//")
            .concat(str);
    System.out.println(path);
}