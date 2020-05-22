CharsetDecoder dec=StandardCharsets.UTF_8.newDecoder()
                  .onMalformedInput(CodingErrorAction.REPLACE);
Path path=Paths.get(getClass().getClassLoader().getResource("bigtest.txt").toURI());
List<String> lines;
try(Reader r=Channels.newReader(FileChannel.open(path), dec, -1);
    BufferedReader br=new BufferedReader(r)) {
        lines=br.lines()
                .filter(s->!s.contains(dec.replacement()))
                .filter(s -> s.regionMatches(true, 0, "aa", 0, 2))
                .collect(Collectors.toList());
}