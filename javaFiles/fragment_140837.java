public Boolean searchPrefix(String word) {
    TrieNode temp = this.root;
    for (int i = 0; i < word.length(); i++){
        TrieNode next = temp.children.get(word.charAt(i));
        if (next == null) {
            return false;
        }
        temp = next;
    }
    return !temp.children.isEmpty() || temp.isWord;
}