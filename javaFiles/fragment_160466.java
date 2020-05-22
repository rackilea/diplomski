public static void main(String[] args) {
  new Parser(new File[]{}, Template1::new);
}

Parser(File[] files, Function<File, Template> templateFactory) {
  for (File f : files) {
    Template t = templateFactory.apply(f);
  }
}