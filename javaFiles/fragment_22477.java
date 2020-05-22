public List<T> autoCompleteItems(final String query) {
  List<T> results = ...; // Find results for the query
  addBoundValue(Components.getCurrentComponent(), results);
  return results;
}

protected void addBoundValue(UIInput input, List<T> results) {
  if (input.getValue() != null && typeTclass.isAssignableFrom(input.getValue().getClass())) {
    T bound = typeTclass.cast(input.getValue());
    results.remove(bound); // If it's already in the list, remove it first
    results.add(0, bound); // Add the value at the top of the list
  }
}