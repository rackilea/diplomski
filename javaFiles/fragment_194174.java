Stream<String> lines1 = Files.lines(Paths.get("/somepathtofile"));
Stream<String> lines2 = Files.lines(Paths.get("/somepathtoanotherfile"));

Stream.concat(lines1, lines)
    .filter(...)
    .forEach(...);