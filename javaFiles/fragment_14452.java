String[] input = {
                "lo.cat.tion", // - no match
                "location", // - match
                "loc_ation", // - match
                "loc.ation" // - match
        };
//                           | start of input
//                           || non dots, 0 or more
//                           ||    | 1 dot or nothing (dot requires \\escaping here)
//                           ||    |   | non dots, 0 or more
//                           ||    |   |    | end of input
Pattern p = Pattern.compile("^[^.]*\\.?[^.]*$");
for (String s: input) {
    Matcher m = p.matcher(s);
    // we use "matches" instead of "find", to match the entire input here, 
    // although in this context both methods yield equivalent results
    System.out.printf("Matches for \"%s\"? %b%n", s, m.matches());
}