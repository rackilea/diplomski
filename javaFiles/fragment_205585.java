Path path = Paths.get("sample.txt");
Files.lines(path, Charset.defaultCharset())
    .forEach(line -> {
        String[] splitted = read.split("systemSerialNumber:");
        if (splitted.length == 2) {
            ...
        }
    });