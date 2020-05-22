public static void main(String[] args) {
    List<Test> list = new ArrayList<>();
    Test test = new Test();
    test.x = 1;
    list.add(test);
    test.x = 2;
    list.add(test);
    test.x = 3;
    list.add(test);
    System.out.println(list.stream().map(c -> new Pair<>(c.x, c == test)).collect(Collectors.toList()));
}

private static class Test {
    int x;
}