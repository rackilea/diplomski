Iterator<String> sentenceIterator = SENTENCES.iterator();

sentenceLoop:
while (sentenceIterator.hasNext())
{
  String sentence = sentenceIterator.next();

  for (String word : sentence.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+"))
  {
    if (WORDS.contains(word))
    {
      sentenceIterator.remove();
      continue sentenceLoop;
    }
  }      
}