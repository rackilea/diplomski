public class Pokemon {
    private String name;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private int hp;

    public int getHP() { return this.hp; }
    public void setHP(int hp) { this.hp = hp; }

    // Repeat the pattern for all properties that describe a Pokemon
    // hp, attack, defense, special attack, special defense, and speed
}