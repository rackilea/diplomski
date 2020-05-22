String input = "-2.2\t2\t3\t4\t329\t2\n" +
               "2.2\t12345q\t69\t-afg\n" +
               "2.2\t12345q\t69\t-asdf\n" +
               "-22\t1234234\tasdfasf\tasdgas\n" +
               "-22\t11\tabc\n" +
               "-22\t-3\t4\n" +
               "-1.1\n" +
               "qqqq\t1.1";
List<List<String>> data = new ArrayList<>();
try (BufferedReader in = new BufferedReader(new StringReader(input))) {
    for (String line; (line = in.readLine()) != null; )
        data.add(Arrays.asList(line.split("\t")));
}
data.sort(new NumberStringComparator());
data.forEach(System.out::println);