/*
 * Apply two arguments. The created function accepts a String and
 * returns a StringBuilder
 */
Function<String, StringBuilder> addEllipsis = appendToMe -> appendChar(
        '.', 3, appendToMe);
/*
 * Apply one argument. This creates a function that takes another two
 * arguments and returns a StringBuilder
 */
BiFunction<String, Integer, StringBuilder> addBangs = (appendToMe,
        times) -> appendChar('!', times, appendToMe);

// Create a function by applying one argument to another function
Function<String, StringBuilder> addOneBang = appendToMe -> addBangs
        .apply(appendToMe, 1);

StringBuilder res1 = addBangs.apply("Java has gone functional", 2);
StringBuilder res2 = addOneBang.apply("Lambdas are sweet");
StringBuilder res3 = addEllipsis.apply("To be continued");