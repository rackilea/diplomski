public void addWord(String zipCodeStr) {
   if (root == null){
        root = new TrieNode();
   }
   TrieNode current = root;
   for (char c : zipCodeStr.toCharArray()) {
       if (current.children == null) {
           current.children = new TrieNode[10];
       }
       if (current.children[Character.getNumericValue(c)] == null) {
           current.children[Character.getNumericValue(c)] = new TrieNode();
       }
       current = current.children[Character.getNumericValue(c)];
   }
   current.isWord = true;
}