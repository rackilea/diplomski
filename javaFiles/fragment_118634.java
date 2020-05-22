URL url = new URL("http://www.nbp.pl/kursy/xml/dir.txt");
URLConnection conn = url.openConnection();
Pattern identifier = getIdentifier("c", LocalDate.of(2019, Month.FEBRUARY, 5));
try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
    reader.lines()
            .filter(line -> identifier.matcher(line).matches())
            .forEach(System.out::println);
}