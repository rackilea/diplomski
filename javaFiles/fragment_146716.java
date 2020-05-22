foo(int x, Grok g1, Grok... rest) {
     Grok[] groks = new Grok[rest.length + 1];
     groks[0] = g1;
     System.arrayCopy(rest, 0, groks, 1, rest.length);
     foo(x, groks);
}