private static int count(Token t, TextChunks tc) {
  int cont = 0;
  for (Token token : tc.arrt) {
      if ( t.compareTwoToken(token) ) {
          cont++;
      }
  }
  return cont;
}