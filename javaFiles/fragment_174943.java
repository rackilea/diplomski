public List<String> findWordsOfLength(int length) {
    // Create new empty list for results
    List<String> results = new ArrayList<>();
    // Start at the root node (level 0)...
    findWordsOfLength(root, "", 0, length, results);
    // Return the results
    return results;
}

public void findWordsOfLength(Node node, String wordSoFar, int depth, int maxDepth, List<String> results) {
    // Go through each "child" of this node
    for(int k = 0; k < node.next.length; k++) {
       Node child = node.next[k];
       // If this child exists...
       if(child != null) {
           // Work out the letter that this child represents
           char letter = 'a' + k;
           // If we have reached "maxDepth" letters...
           if(depth == maxDepth) {
               // Add this letter to the end of the word so far and then add the word to the results list
               results.add(wordSoFar + letter);
           } else {
               // Otherwise recurse to the next level
               findWordsOfLength(child, wordSoDar + letter, depth + 1, maxDepth, results);
           }
       }
    }
}