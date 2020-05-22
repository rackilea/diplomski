Stream<Result> parse(String _line) {
  .. code here
  Result _result = new Result().
  if (/* line is not needed */) {
    return Stream.empty();
  } else {
    /** parse line into result */
   return Stream.of(_result);
  }
}  

public Stream<Result> parseFile(Path _file) {
  return Files.lines(_file)
              .flatMap(this::parse);
}