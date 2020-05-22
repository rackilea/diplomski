public int count(String a, String[] b) {
    String[] words = a.split(" ");
    int tokens = words.length;
    int wordCount = 0;
    int counter = 0;
    for(int i=0;i<tokens;i++) {
        String token = words[i].trim();
        if(token.length() <= 0) {
            continue;
        }
        wordCount++;
        for(String bItem : b) {
            if(bItem.equals(token)) {
                counter++;
                break;
            }
        }
    }
    return wordCount - counter;
}