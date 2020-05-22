public void parse(String input){
InputStream modelIn = null;
try {
    modelIn = new FileInputStream("en-parser-chunking.bin");
  ParserModel model = new ParserModel(modelIn);
    opennlp.tools.parser.Parser parser = ParserFactory.create(model);
    opennlp.tools.parser.Parse topParses[] = ParserTool.parseLine(input, parser, 1);
    for (opennlp.tools.parser.Parse p : topParses){

      StringBuilder sb = new StringBuilder(input.length() * 4);
      p.show(sb);
      //sb now contains all the tags
      System.out.println(sb);

    }
}catch (IOException e) {
  e.printStackTrace();
}finally {
  if (modelIn != null) {
    try {
      modelIn.close();
    }
    catch (IOException e) {
    }
  }
}
}