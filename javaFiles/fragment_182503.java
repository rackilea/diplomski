public int countFirstNameOccurrences(char c) {
        return (int)Reg.stream() //Stream<Name>
                       .map(Name::getFirstName) // Stream<String>
                       .filter(n -> n.charAt(n.length() -1) == c) // Stream<String>
                       .count(); // long
}