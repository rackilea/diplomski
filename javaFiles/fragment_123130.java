// map where the key is the length of a word and
// the value is the number of words of that length
Map<Integer, Integer> numberOfWordsOfLength = new HashMap<>();

Scanner dictionaryScanner = new Scanner(file);

while (dictionaryScanner.hasNext())
{
   String word = dictionaryScanner.next();
   int wordLength = word.length();
   numberOfWordsOfLength.put(wordLength, 1 +
      numberOfWordsOfLength.containsKey(wordLength) ?
      numberOfWordsOfLength.get(wordLength) :
      0);
}