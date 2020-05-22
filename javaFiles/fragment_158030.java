List<String> getOneElementData(argument) {
    return getDataInternal(argument, elements -> elements.size < 1);
}

//You can even extend the above to take the desired final list size as a parameter
// and have the predicate as elements -> elements.size < desiredSize

List<String> getData(argument) {
      return getDataInternal(argument, elements -> true); //Always keep going
}

private List<String> getDataInternal(argument, Predicate<List<String>> shouldContinue) {
  List<String> elements = new ArrayList<>;
  ... // do some heavy stuff that produces flag 'shouldAddElement'

  if (shouldAddElement) {
    elements.add('a');
  }

  if (someCondition && shouldContinue.test(elements)) {
    elements.addAll(getData(argument));
  }

  return elements;
}