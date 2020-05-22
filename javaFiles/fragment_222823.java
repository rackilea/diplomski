public static void compare_letters(String name1, String name2) {

    // Declare a couple of sets: sets don't allow duplicate elements.
    Set<Character> letters1 = new HashSet<Character>();
    Set<Character> letters2 = new HashSet<Character>();

    // Populate the sets with the letters from the strings.
    for( char c : name1.toCharArray() ) letters1.add(c);
    for( char c : name2.toCharArray() ) letters2.add(c);

    // remove anything that isn't in letters2 from letters1
    letters1.retainAll(letters2);

    // letters1 is now the set of letters that appear in both names.
    // Its size is the number of common letters.
    System.out.println("num of equal letters " + letters1.size(););
}