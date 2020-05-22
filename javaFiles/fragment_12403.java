Stream<String> uncommentedLines(Stream<String> lines) {
    AtomicBoolean insideBlockComment = new AtomicBoolean();
    return lines.flatMap(line -> {
        if (insideBlockComment.get()) {
            int p = line.indexOf("*/");
            if (p != -1) {
                insideBlockComment.set(false);
                return line.substring(p + 2);
            }
            return Stream.empty();
        } else {
            int p = line.indexOf("//");
            if (p != -1) {
                line = line.substring(0, p);
            }
            p = line.indexOf("/*");
            if (p != -1) {
                insideBlockComment.set(true);
                line = line.substring(0, p);
            }
            return Stream.of(line);
        }
    });
}