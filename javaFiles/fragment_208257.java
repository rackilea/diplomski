try (Stream<String> lines = Files.lines(path)) {
    lines.flatMap(input ->
            pattern.matcher(input).results()
    ).forEach(matchResult -> System.out.println("Match: " + matchResult.group(1)));
} catch (IOException e) {
    e.printStackTrace();
}