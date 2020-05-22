public static String generate(String letters, long number) {
    // get a list of the all the possible characters assuming no duplicates.
    List<Character> chars = new ArrayList<>(letters.length());
    for (int i = 0; i < letters.length(); i++)
        chars.add(letters.charAt(i));
    // start with a string builder.
    StringBuilder ret = new StringBuilder(letters.length());

    // while we have characters left
    while(chars.length() > 0) {
       // select one of the unused characters
       int select = number % chars.length();
       // take out the lower portion of the number and use the next portion
       number /= chars.length();
       // Append the N-th character, but remove it so it doesn't get used again.
       ret.append(chars.remove(select));
    }
    assert number == 0; // otherwise we have not enough letters.
    return ret;
}