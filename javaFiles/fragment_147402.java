public SaveCsv {
  private final File file;

  public SaveCsv(File file){
    this.file = file
  }

  public void savePlayer(Map<Integer, Player> playerHash) {
    if (!file.exists()) {
      file.mkdir();
    }
    ...
  }
}