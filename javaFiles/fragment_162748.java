final String regex = "\\d*\\.?\\d+";
final Pattern pattern = Pattern.compile(regex);

try (StreamEx<String> stream = StreamEx.ofLines(file, StandardCharsets.UTF_8)) {
    stream.splitToList(52).filter(l -> l.size() == 52).forEach(lines -> {
        lines.stream().forEach(line -> {
            final Matcher matcher = pattern.matcher(line); // No reason do: line.substring(0)
            while (matcher.find()) {
                // testPop.add(Double.parseDouble(matcher.group(0)));
            }
        });

        try {
            // TODO:
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException x) {
            // readToExcel(currentLine + 52);
        }
    });
} catch (IOException e) {
    e.printStackTrace();
}