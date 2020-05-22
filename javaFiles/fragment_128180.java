List<String> keys = Arrays.asList("int", "float", "if", "else", "double");

Optional<String> possibleMatch = keys.stream()
    .filter(a::contains) // if a contains one of the keys return true
    .findFirst(); // find the first match 

if (possibleMatch.isPresent()) { // if a match is present
  System.out.println(possibleMatch.get()); // print the match
}