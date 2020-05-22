private void buildModel(int K, String sourceText) {
  if (sourceText == null) throw new NullPointerException("sourceText parameter is NULL literal");  

  if(K < 0 || sourceText.length() < K) {
     throw new IOException();
  }

  ...