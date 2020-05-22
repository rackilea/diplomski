protected Iterable<String> loadRules( String synonyms, ResourceLoader loader ) {
    List<String> wlist=null;
    try {
      File synonymFile = new File(synonyms);
      if (synonymFile.exists()) {
        wlist = loader.getLines(synonyms);
      } else  {
        List<String> files = StrUtils.splitFileNames(synonyms);
        wlist = new ArrayList<String>();
        for (String file : files) {
          List<String> lines = loader.getLines(file.trim());
          wlist.addAll(lines);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return wlist;
}