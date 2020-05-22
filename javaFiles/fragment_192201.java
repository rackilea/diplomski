for (int j =0 j < tempsArray.length; j ++ ) { 
  for (int n = 1; n <= 3; n++) {
    for (String ngram : ngrams(n, tempsArray[j] ))
      System.out.println(ngram);
    System.out.println();
  }
}