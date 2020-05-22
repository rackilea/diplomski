private Map<String, Collection<String>> myDictionary = new HashMap<>();

public void addWord(String word, String definition) {
    Collection definitions = myDictionary.get(word);
    if(definitions == null) {
         definitions = new ArrayList<String>();
         myDictionary.put(word, definitions);
    }
    definitions.add(definition);
}