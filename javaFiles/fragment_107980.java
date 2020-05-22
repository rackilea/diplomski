public static void main(String[] args) throws IOException {
    Pattern pattern = Pattern.compile("(\\d+)");
    try (Stream<String> stream = Files.lines(Paths.get("file"))) {
        int sum = 
            stream.filter(line -> line.contains("PL"))
                  .map(pattern::matcher)
                  .filter(Matcher::find)
                  .map(m -> Integer.valueOf(m.group(1)))
                  .sorted(Comparator.reverseOrder())
                  .limit(3)
                  .mapToInt(Integer::intValue)
                  .sum();
        System.out.println(sum);
    }
}