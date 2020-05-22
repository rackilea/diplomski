final String regex = "\\d*\\.?\\d+";
final Pattern pattern = Pattern.compile(regex);

try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
    final Iterator<String> iter = lines.iterator();

    for (int currentLine = 1; iter.hasNext(); currentLine++) {
        String line = iter.next();
        final Matcher matcher = pattern.matcher(line); // No reason do: line.substring(0)
        while (matcher.find()) {
            // testPop.add(Double.parseDouble(matcher.group(0)));
        }

        try {
            if (currentLine % 52 == 0) {
                for (int i = 0; i < 52; i++) {
                    // TODO
                }
            }

            // TODO:
        } catch (IOException ioe) {
            ioe.printStackTrace();
            while (currentLine % 52 != 0 && iter.hasNext()) {
                iter.next();
                currentLine++;
            }
        } catch (NullPointerException x) {
            // readToExcel(currentLine + 52);
            while (currentLine % 52 != 0 && iter.hasNext()) {
                iter.next();
                currentLine++;
            }
        }
    }
}