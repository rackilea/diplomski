HashMap<String, int> wordCountMap = new HashMap<String, int>();
for(....) // for each 3 letter word in the input
{
    String word = ...; // current three letter word
    if(wordCountMap.containsKey(word))
        wordCountMap.put(word, wordCountMap.get(word)++);
    else
        wordCountMap.put(word, 1);
}