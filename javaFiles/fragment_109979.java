public class MaxSizeFileFilter implements FileFilter {
  private final static long MAX_SIZE = (1024L * 1024L);
  private final static String SUFFIX_REGEX = ".*\\.(png|jpg|gif|bmp|jpeg)";

  @Override
  public boolean accept(File file) {
    try {
        return file != null &&
            file.isFile() &&
            file.canRead() &&
            file.getName().matches(SUFFIX_REGEX) &&
            file.length() <= MAX_SIZE;
    }
    catch (SecurityException exc) {
        System.err.println(exc.getMessage());
        return false;
    }
  }
}