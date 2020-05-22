InputStream modelIn = new FileInputStream("pt-ner.bin");

try {
  TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
}
catch (IOException e) {
  e.printStackTrace();
}
finally {
  if (modelIn != null) {
    try {
       modelIn.close();
    }
    catch (IOException e) {
    }
  }
}

// load the name finder
NameFinderME nameFinder = new NameFinderME(model);

// pass the token array to the name finder
String[] toks = {"Meu","nome","é","João","da","Silva",",","moro","no","Brasil",".","Trabalho","na","Petrobras","e","tenho","50","anos","."};

// the Span objects will show the start and end of each name, also the type
Span[] nameSpans = nameFinder.find(toks);