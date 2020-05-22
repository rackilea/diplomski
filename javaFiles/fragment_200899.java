public static void updateFrequencyOfTokenInTextChunks (TextChunks tc) {
  Hashtable<String,Integer> visited = new Hashtable<String,Integer>();

  for (Token token : tc.arrt){
    if (visited.containsKey(token.s)) {
        token.frequency = visited.get(token.s);
    } else {
        int n = count(token, tc);
        visited.put(token.s, n);
        token.frequency = n;
    }
  }
}