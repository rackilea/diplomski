public static void main(String... ignored) throws IOException {
    Player player = new Player();
    player.load("Player.sav");
    player.test();
}

public void load(String filename) throws IOException {
  try (FileInputStream saveFile = new FileInputStream(filename);
    ObjectInputStream save = new ObjectInputStream(saveFile)) {
    naturalTalent = (Integer) save.readObject();
    luck = (Integer) save.readObject();
    figure = (Integer) save.readObject();
    agility = (Integer) save.readObject();
    intelligence = (Integer) save.readObject();
    multiTasking = (Integer) save.readObject();
    stamina = (Integer) save.readObject();
  }
}