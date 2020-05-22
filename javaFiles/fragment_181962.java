// split coordinates string into (x, y) pairs by using
// regex lookahead to find the next alphabetical character
for (String coord : "a4c23d17".split("(?=[a-z])")) {
    // subtract the ascii value of 'a' from
    // the first char to get the numeric offset
    System.out.println(coord.charAt(0) - 'a' + 1);
    // parse the remainder as an integer
    System.out.println(Integer.parseInt(coord.substring(1)));
}