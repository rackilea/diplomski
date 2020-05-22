class TrieNode{
    private TrieNode parent;
    private boolean isWord;
    private boolean hasChildren;
    private char character;
    private Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(){
        this.hasChildren = false;
        this.isWord = false;
    }
    public TrieNode (char ch) {
        this.character = ch;
        this.hasChildren = false;
        this.isWord = false;
    }

    public void addWord (String word){
        if (word.length() == 0) {
            this.isWord = true;
            System.out.println( character + " -- " + isWord);
            return;
        }

        // represent the Child Node;
        //       --
        char firstChar = word.charAt(0);
        TrieNode child = children.get( firstChar);
        if (child == null){
            child = new TrieNode( firstChar);
            children.put( firstChar, child);
            child.parent = this;
            hasChildren = true;
        }

        // add Remaining Word;
        //      -- call for 1-length words, as 0-length at Child sets 'IsWord'!
        child.addWord( word.substring(1));

        // print building here.
        System.out.println( character + " -- " + isWord);
    }



    public void findWords(){
        for(Character key : children.keySet()){
            children.get(key).findWords();
        }
        System.out.println( character + " -- " + isWord);     
    }
}