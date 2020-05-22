String[] inputs = {
    "hello how are you...", // -> VALID
    "hello how are you.............", // -> INVALID
    "hiii", // -> VALID
    "hiiiiii" // -> INVALID
};
//                            | group 1 - any character
//                            | | back-reference
//                            | |   | 4+ quantifier including previous instance
//                            | |   |     | dot represents any character, 
//                            | |   |     | including whitespace and line feeds
//                            | |   |     | 
Pattern p = Pattern.compile("(.)\\1{3,}", Pattern.DOTALL);
// iterating test inputs
for (String s: inputs) {
    // matching
    Matcher m = p.matcher(s);
    // 4+ repeated character found
    if (m.find()) {
        System.out.printf(
            "Input '%s' not valid, character '%s' repeated more than 3 times%n", 
            s, 
            m.group(1)
        );
    }
}