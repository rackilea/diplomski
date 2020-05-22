public static void main(String[] args) {
    String s = ",Test1,,Test2";

    List<String> collect = Arrays.stream(s.split(","))
            .map(t -> "[" + t + "]")
            .collect(Collectors.toList());

    System.out.println(collect);
}