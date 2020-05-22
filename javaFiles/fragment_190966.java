SquidAstVisitorContextImpl<Grammar> savci = new SquidAstVisitorContextImpl<Grammar>(new SourceProject("Custom Grammar"));
AstScanner.Builder b = AstScanner.builder(savci);

b.setBaseParser(ExampleParser.create());
b.setCommentAnalyser(new CommentAnalyser {
  @override
  public bool isBlank(String line) {
    return true;
  }
  @override
  public String getContents(String comment) {
    return "";
  }
});
b.setFileMetric(FILES); // I am not sure what a 'Metric' is as both the documentation and source are unclear on that, you may have to experiment with this value.

b.withSquidAstVisitor(new ExampleRule());

AstScanner<Grammar> as = b.build();
as.scanFile(new File("path/to/source"));