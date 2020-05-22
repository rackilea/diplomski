ArrayList<String> lowerCaseListOfPhrases = new ArrayList<String>(ListOfAllPhrase.size());
for (String phrase : ListOfAllPhrase) {
    lowerCaseListOfPhrases.add(phrase.toLowerCase());
}
String lowerCaseLine = line.toLowerCase();
for (String phrase : lowerCaseListOfPhrases) {
  List<Integer> matches = match(phrase, lowerCaseLine);
    for (Integer integer : matches) {
        pairs.add(new Pair(integer, phrase.length() + integer));
    }

}