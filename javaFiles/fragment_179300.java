List<String> textFiles(String directory) {
      List<String> textFiles = new ArrayList<String>();
      File dir = new File(directory);
      for (File file : dir.listFiles()) {
        if (file.getName().endsWith((".txt"))) {
          textFiles.add(file.getPath());
        }
      }
      return textFiles;
    }