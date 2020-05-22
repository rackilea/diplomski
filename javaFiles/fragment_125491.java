String regex = "(?=((Bob|Mary)\\b[^\\.\\?!]*?\\b(Paris|London)\\b.*?[\\.\\?!]))";
Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern
        .matcher("Bob and Mary are planning to go to Paris. They want to leave before July.");
while (matcher.find()){
    System.out.println(matcher.group(1));
}