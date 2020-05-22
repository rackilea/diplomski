import java.io.File;
import java.util.regex.Pattern;

private static void walkDir(final File dir, final Pattern pattern) {
  final File[] files = dir.listFiles();
  if (files != null) {
    for (final File file : files) {
      if (file.isDirectory()) {
        walkDir(file, pattern);
      } else if (pattern.matcher(file.getName()).matches()) {
        System.out.println("file to delete: " + file.getAbsolutePath());
      }
    }
  }
}

public static void main(String[] args) {
  walkDir(new File("/home/user/something"), Pattern.compile(".*\\.mp3"));
}