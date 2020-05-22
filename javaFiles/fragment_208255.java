try (Stream<String> lines = Files.lines(path)) {
    lines.forEach(line ->
            {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    System.out.println("Match: " + matcher.group(1));
                }
            }
    );
} catch (Exception e) {
    e.printStackTrace();
}