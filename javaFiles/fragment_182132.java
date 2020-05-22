File file = new File("/path/to/directory");
String[] directories = file.list(new FilenameFilter() {
  @Override
  public boolean accept(File current, String name) {
    return new File(current, name).isDirectory();
  }
});
System.out.println(Arrays.toString(directories));