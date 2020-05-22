public static void main(String[] args) {
    Map<Integer, Set<String>> levelSet = new HashMap();
    //Your code goes here to get the level and word
    //
    String word="";
    int level=0;
    addStringToLevel(levelSet,word,level);

    }

    private static void addStringToLevel(Map<Integer, Set<String>> levelSet,
            String word, int level) {
        if(levelSet.get(level) == null)
        {
            // this means this is the first string added for this level
            // so create a container to hold the object
            levelSet.put(level, new HashSet()); 
        }

        Set<String> wordContainer = levelSet.get(level);
        wordContainer.add(word);
    }

    private static String getStringFromLevel(Map<Integer, Set<String>> levelSet,
            int level) {
        if(levelSet.get(level) == null)
        {
            return null;
        }

        Set<String> wordContainer = levelSet.get(level);
        return "";// return a random string from wordContainer`
    }