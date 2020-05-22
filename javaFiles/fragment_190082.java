static private IDontKnow getStream(Component3Choice c3c) {
  if (c3c instanceof OptionalComponent3Bean) {
    return ((OptionalComponent3Bean)c3c).getStream();
  } else if (c3c instanceof RequiredComponent3Bean) {
    return ((RequiredComponent3Bean)c3c).getStream();
  } else {
    return null;
  }
}

components.stream()
  .map(x -> getStream(x))
  .filter(x -> x!=null)
  .findFirst()
  .map(x -> x.getEntry().stream());
  ... continue on with yout processing