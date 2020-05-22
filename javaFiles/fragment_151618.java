String[] namesWithRepeatedOneLetter = { "RAAAJ", "ABBBAAS" };
String[] namesWithRepeatedTwoLetters = { "ABABABC", "FOOBCBCD"};
//                            | This is a posix character class, basically your a-zA-Z 
//                            | range. Note the parenthesis which define it as a group.
//                            |           | This is a reference to previously declared
//                            |           | group (as group 1)
//                            |           |  | Greedy quantifier for more than 2 
//                            |           |  | letter repeat
Pattern p0 = Pattern.compile("(\\p{Alpha})\\1{2,}");
//                                       | Greedy quantifier for 2+ repeats (so 
//                                       | repetition is considered as such with 2 
//                                       | letter groups
Pattern p1 = Pattern.compile("(\\p{Alpha}{2,})\\1{2,}");
for (String n : namesWithRepeatedOneLetter) {
    Matcher m = p0.matcher(n);
    while (m.find()) {
        System.out.println(m.group());
    }
}
System.out.println();
for (String n: namesWithRepeatedTwoLetters) {
    Matcher m = p1.matcher(n);
    while (m.find()) {
        System.out.println(m.group());
    }
}