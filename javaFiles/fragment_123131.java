int wordIndex = new Random().nextInt(numberOfWordsOfLength.get(length));
Scanner dictionaryScanner = new Scanner(file);
String word;
while (dictionaryScanner.hasNext())
{
   String candidateWord = dictionaryScanner.next();
   if (candidateWord.length() != length) continue;
   if (wordIndex == 0)
   {
      word = candidateWord;
      break;
   }
   --wordIndex;
}