public static void main(String[] args) {
  new Parser(new File[]{}, Template1::new);
}

Parser(File[] files, Supplier<Template> templateFactory) {
  for (File f : files) {
    Template t = templateFactory.get();
  }
}