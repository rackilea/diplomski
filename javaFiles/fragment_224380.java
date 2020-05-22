File orig = new File("\test\orig");
    File[] directories = orig.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });
    ArrayList<File> files = new ArrayList<File>();
    for (File directory : directories) {
        File file = new File(directory, "test.zip");
        if (file.exists())
            files.add(file);
    }
    System.out.println(files.toString());