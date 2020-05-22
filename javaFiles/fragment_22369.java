private SearchResult checkAddress(String address) {
  // on address search succeed
  return new SearchResult(foundName, true);
  :
  // on address search failed
  return new SearchResult(null, false);
}