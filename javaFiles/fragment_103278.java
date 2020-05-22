import static java.util.stream.Collectors.toMap;
//skipped
Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s*:\\s*(.*)");
try (Stream<String> stream = Files.lines(Paths.get("<PATH_TO_FILE>"))) {
    Map<String, String> results =
            stream.map(pattern::matcher)
                    .filter(Matcher::find)
                    .collect(toMap(a -> a.group(1), a -> a.group(2)));
}