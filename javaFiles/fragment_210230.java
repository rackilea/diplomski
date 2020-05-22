static int patternCount(String s){
    Pattern pattern = Pattern.compile("(?<=1)[0]+(?=1)");
    Matcher  matcher = pattern.matcher(s);
    int count = 0;
    while (matcher.find())
        count++;
    return count;
}