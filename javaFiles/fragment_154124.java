// You need this only once per JVM.
// Note that running inside IDEs like Netbeans may change the default encoding
char[] table = getTable(Charset.defaultCharset());

try(Stream<Path> stream = Files.walk(Paths.get(FILES_DIRECTORY))
                               .filter(Files::isRegularFile)) {
    Pattern pattern = Pattern.compile(String.join("|", Strings_PASSWORDS));
    long startTime = System.nanoTime();
    final List<Path> filesWithObviousStringss = stream//.parallel()
            .filter(path -> {
                try {
                    return pattern.matcher(mapAsciiBasedText(path, table)).find();
                } catch(IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            })
            .collect(Collectors.toList());
    System.out.println("Time taken = "
        + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()-startTime) + " seconds");
}