Pattern pattern = Pattern.compile(".?Test (.)");
try (Stream<String> lines = Files.lines(path)) {
    lines.forEach(input -> pattern.matcher(input)
            .results()
            .forEach(matcher -> System.out.println("Match: " + matcher.group(1)))
    );
} catch (Exception e) {
    e.printStackTrace();
}