public static void main(String[] args) {
  new Parser(new File[]{}, Template1::new);
}

Parser(File[] files, TemplateFactory templateFactory) {
  for (File f : files) {
    Template t = templateFactory.createFrom(f);
  }
}

public static interface TemplateFactory {
  Template createFrom(File file);
}