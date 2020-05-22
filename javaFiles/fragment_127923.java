Stream.of(IOUtil.readLines(new File(filePath)))
    .map(line -> Splitter.with(" ").trim(true).splitToArray(line))
    .groupBy(a -> a[1], a -> a[0], (a, b) -> a + ", " + b)
    .forEach(N::println);
// output:
// female=Julia, Mia
// male=Marwan, John, William