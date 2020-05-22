for (String t: tempsArray ) { 
  for (int n = 1; n <= 3; n++) {
    for (String ngram : ngrams(n, t))
      System.out.println(ngram);
    System.out.println();
  }
}