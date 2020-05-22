public static File getFileByName(String name, String path) throws IOException {
    ArrayList<File> files = new ArrayList<>();
    Files.newDirectoryStream(Paths.get(path))
         .forEach(p -> {
           if (p.getFileName()
                   .equals(name))
             files.add(p.toFile());
         });
    return files.size() > 0 ? files.get(0) : null;
  }