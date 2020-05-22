Filter readAndFilter(Iterable<String> fileLines) {
  List<Filter> subfilters = new ArrayList<Filter>();
  for (String line : fileLines) {
    subfilters.add(readOrFilter(line));
  }
  return new AndFilter(subfilters);
}

Filter readOrFilter(String fileLine) {
  List<Filter> subfilters = new ArrayList<Filter>();
  for (String oneFilter : fileLine.split(" ")) {
    Filter filter = buildOneFilter(oneFilter);
    subfilters.add(filter);
  }
  return new OrFilter(subfilters);
}

Filter buildOneFilter(String oneFilterClause) {
  // parse as you were doing before
}