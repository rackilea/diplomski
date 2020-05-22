String quote = "aba*abaa**aabaa***";    
Pattern pattern = Pattern.compile("a\\**");
Matcher matcher = pattern.matcher(quote);
List<String> words = new ArrayList<String>();
int start = 0;
while(matcher.find()) {
    if(start < matcher.start()) {
        words.add(quote.substring(start, matcher.start()));
    }
    words.add(matcher.group());
    start = matcher.end();
}