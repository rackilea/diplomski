private static class MyFileCallable implements FileCallable<String> {
  private static final long serialVersionUID = 1L;
  @Override
  public String invoke(File file, VirtualChannel channel) throws IOException, InterruptedException {
    if (file.getAbsoluteFile().exists()){
      return file.getName() + " exists.";
    } else {
      return file.getName() + " doesn't exist.";
    }
  }
}