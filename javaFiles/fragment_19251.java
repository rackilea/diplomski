public static void main(String[] args) {
    String[] lines = new String[4];
    lines[0] = "812.12 135.14 646.17 1";
    lines[1] = "812.12 135.14 646.18 1";
    lines[2] = "812.12 135.14 646.19 2";
    lines[3] = "812.12 135.14 646.20 2";

    // first one is done separately to extract last character
    // for comparisons (for next iterations)
    char lastChar = lines[0].charAt(lines[0].length()-1);
    lines[0] = lines[0].substring(0, lines[0].length()-2);

    // start from index 1 since index 0 was already processed
    for(int i=1;i<lines.length; i++){
        // get last character
        char tmp = lines[i].charAt(lines[i].length()-1);

        // remove last character
        lines[i] = lines[i].substring(0, lines[i].length()-2);

        // if last character from this line isn't the same like
        // the last character from previous line, add S
        if(tmp != lastChar)
            lines[i] = "S " + lines[i];

        // update lastChar for comparison
        lastChar = tmp;
    }

    for(int i=0;i<lines.length;i++)
        System.out.println(lines[i]);
}