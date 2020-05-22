CharsetDecoder dec=StandardCharsets.UTF_8.newDecoder()
                  .onMalformedInput(CodingErrorAction.IGNORE);
Path path=Paths.get(getClass().getClassLoader().getResource("bigtest.txt").toURI());
List<String> lines;
try(Reader r=Channels.newReader(FileChannel.open(path), dec, -1);
    BufferedReader br=new BufferedReader(r)) {
        lines=br.lines()
                .filter(s -> s.regionMatches(true, 0, "aa", 0, 2))
                .collect(Collectors.toList());
}