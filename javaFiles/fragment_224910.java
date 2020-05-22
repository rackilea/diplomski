@JsonCreator
public static Player fromStringValues(@JsonProperty("name") String name,
                                      @JsonProperty("characterClass") String characterClass,
                                      @JsonProperty("difficulty") String difficulty,
                                      @JsonProperty("timesDied") Integer timesDied) {
    Player player = new Player();
    player.setPlayerName(name);
    player.setCharacter(new Character(characterClass, difficulty, timesDied));
    return player;
}