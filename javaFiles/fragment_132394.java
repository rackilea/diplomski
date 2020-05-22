public void put(TrieMapNode current, String key, String value, int depth){
if (depth == key.length()){
   current.value = value;
} else {
    char curChar = key.charAt(depth);
    if(!current.getChildren().containsKey(curChar)){
        TrieMapNode newNode = new TrieMapNode();
        current.getChildren().put(curChar, newNode);
    }
    put(current.getChildren().get(curChar), curKey, value, depth + 1);
}