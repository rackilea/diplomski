try {
  Path target = Paths.get(Thread.currentThread().getContextClassLoader()
      .getResource(FILE).toURI());
  System.out.println(target);
} catch (URISyntaxException e) {
  e.printStackTrace();
}