// Iterator<String> fileNames = Arrays.asList("one.txt", "two.txt", "three.txt", "four.txt", "five.txt", "six.txt", "seven.txt").iterator();
int i = 1;
Pattern start = Pattern.compile("\\(AP9000\\)");
Pattern end = Pattern.compile("\\(NNNN\\)");
boolean reading = false;
FileOutputStream fos = null;
Iterator<String> lines = Files.lines(Paths.get("c:/d/test.txt")).iterator();
while (lines.hasNext() /* && fileNames.hasNext() */) {
    String line = lines.next();
    Matcher startMatcher = start.matcher(line);
    if (startMatcher.find()) {
        reading = true;
        fos = new FileOutputStream(String.valueOf(i++) + ".txt"/*fileNames.next()*/);
    }
    if (reading) {
        fos.write(line.getBytes(StandardCharsets.UTF_8));
        fos.write('\n');
    }
    Matcher endMatcher = end.matcher(line);
    if (endMatcher.find()) {
        if (fos != null) {
            fos.close();
        }
        reading = false;
    }
}
if (fos != null) {
    fos.close();
}