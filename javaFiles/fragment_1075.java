public Word findFirst(String text) throws SearchableException, ContentNotLoadedException {
    for(int i = 0;i<words.size();i++) {
        if(text.equals(words.get(i).text)) {
            return words.get(i);
        }
    }   
return null;
}