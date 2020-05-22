public List<String> createList(int listSize)
{
   Random rand = new Random();
   List<String> wordList = rand.
      ints(listSize, 0, sourceWords.size()).
      mapToObj(i -> sourceWords.get(i)).
      collect(Collectors.toList());

   return wordList;
}