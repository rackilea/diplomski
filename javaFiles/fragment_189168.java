stream.map(obj -> doMap(obj))
      .filter(obj -> obj.isPresent())
      .collect(Collectors.toList());

private Optional<String> doMap(Object obj) {
   if (objectIsInvalid) {
    return Optional.empty();
   }
}