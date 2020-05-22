boolean wasInserted = false;
for (int i =0; i < aList.size();i++) {
    String temp = aList.get(i);
    int comparisonResult = word.compareTo(temp) ;
    if (comparisonResult < 0 || comparisonResult == 0) {
        aList.add(i , word);
        wasInserted = true;
        break;
    }
}
if(!wasInserted) {
    aList.add(word);
}