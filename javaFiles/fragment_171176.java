String regex = getRedex(); // This is your B.N...
Pattern pattern = Pattern.compile(regex);
List<String> words=readFromFile(); // The list of words in the text file
for(String word: words){
    Matcher matcher = pattern.matcher(word);
    if(matcher.find()){
        // Match found
        // do what you need to do here
    }else{
        // Same here
    }
}