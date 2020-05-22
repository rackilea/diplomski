List<String> firstWordsList = new ArrayList<>();
List<String> lastWordList = new ArrayList<>();
for(String tempTerm : terms) {
    int lastSpaceIndex = tempTerm.lastIndexOf(" ");
    if (lastSpaceIndex >= 0) {
        String firstWords = tempTerm.substring(0, lastSpaceIndex);
        String lastWord = tempTerm.substring(lastSpaceIndex+1);
        firstWordsList.add(firstWords);
        lastWordsList.add(lastWord);
    }
    else {
        lastWordsList.add(tempTerm);
    }
}