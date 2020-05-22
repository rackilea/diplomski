public static final FileFilter DIRS = new FileFilter() {

  public boolean accept(File file) {
    return file.isDirectory();
  }

};

public static final FileFilter FILES = new FileFilter() {

  public boolean accept(File file) {
    return file.isFile();
  }

}

public void walkTree(File start) throws IOException {

  File[] dirs = start.listFiles(DIRS);
  File[] files = start.listFiles(FILES);

  for (File file : files) {
    if (file.canRead()) {
      if (readAndCheck(file, "string")) {
        // Do Whatever
      }
    }
  }

  for (File dir : dirs) {
    walkTree(dir);
  }

}

public boolean readAndCheck(File file, String string) throws IOException {

  BufferedReader br = null;
  StringBuilder total = new StringBuilder();

  try {

    // If line separators matter in your pattern, consider reading every character
    br = new BufferedReader(new FileReader(file));
    String line;
    while ((line = br.readLine()) != null) {
      total.append(line);
    }

  } finally {
    if (br != null) {
      br.close();
    }
  }

  return total.toString().contains(string);

}