public static void main(String[] args) throws IOException {

    FileWriter writer = new FileWriter("/Users/artur/tmp/csv/sto1.csv");

    List<String> test = new ArrayList<>();
    test.add("Word1");
    test.add("Word2");
    test.add("Word3");
    test.add("Word4");

    String collect = test.stream().collect(Collectors.joining(","));
    System.out.println(collect);

    writer.write(collect);
    writer.close();

}