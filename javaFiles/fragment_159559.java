LineNumberReader numberRdr = new LineNumberReader(Files.newBufferedReader(Paths.get("file")));

List<Integer> linesNumbers = numberRdr.lines()
                                      .filter(w -> w.contains(word))
                                      .map(w -> numberRdr.getLineNumber())
                                      .collect(toList());