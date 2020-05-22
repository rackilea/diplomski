// Return [by, bye] when prefix = by
public List<String> getWords(String prefix)
{
    TrieNode trieNode = searchPrefix(prefix);
    if (trieNode != null) {
        List<String> words = new ArrayList<>();
        addAllWords(trieNode, prefix, words);
        return words;
    }
    return Collections.emptyList();
}

private void addAllWords(TrieNode node, String word, List<String> words)
{
    if (node.isEnd()) {
        words.add(word);
    }
    for(int index = 0;index < 26;index++)
    {
        TrieNode next = node.get((char)(index + 'a'));
        if (next != null) {
            addAllWords(next, word + (char)(index + 'a'), words);
        }
    }
}