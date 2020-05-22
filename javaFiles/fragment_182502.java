public int countFirstNameOccurrences(char c) {
        String character = String.valueOf(c); // character represented as a String
        return Reg.stream()  // Stream<Name>
                  .map(Name::getFirstName) // Stream<String>
                  .mapToInt(n -> n.endsWith(character)? 1 : 0) // IntStream
                  .sum(); // int
}