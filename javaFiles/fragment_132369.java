Function<String,String> addQuotes = new Function<String,String>() {
  @Override public String apply(String s) {
    return new StringBuilder(s.length()+2).append('"').append(s).append('"').toString();
  }
};
String result = Joiner.on(", ").join(Iterables.transform(listOfStrings, addQuotes));