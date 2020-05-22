public String Question1(int numberOfStars) {
    String str = "*";
    while (numberOfStars > 0) {
        numberOfStars--;
        return str;
    }
    // compiler thinks: "what if the code gets here?"
    // no String would be returned
}