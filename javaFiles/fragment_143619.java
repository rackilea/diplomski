String longestWord(Node d) {
  String result = d.theWord;
  for (Node c : d.children) {
     String w = longestWord(c);
     if (result.length < w.length) result = w;
  }
  return result;
}