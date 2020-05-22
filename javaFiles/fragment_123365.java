public class Character {

  // "Global" Map that tracks all Character instances by ID
  private static HashMap<Integer, Character> idToCharacter = new HashMap<>();

  // Fields, etc...

  public Character(String name, int health, int damage, int id) {
    // Set field values, etc...

    // Track this new Character
    idToCharacter.put(id);
  }

  // "Global" method for getting a Character by ID
  public static Character getCharacter(int id) {
    return idToCharacter.get(id);
  }

}