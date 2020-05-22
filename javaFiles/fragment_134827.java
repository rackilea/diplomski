// Lives in core
public class Monster {
    public String name;     // prénom
    public int hitpoints;   // points de dommage

    public Monster() {
        this.name = "Tim the Unnamed";
        this.hitpoints = 1;
    }
    public Monster(String name, int hitpoints) {
        this.name = name;
        this.hitpoints = hitpoints;
    }
    @Override
    public String toString() {
        return String.format("{name: '%s', hitpoints: %n}", this.name, this.hitpoints);
    }

    public void attack(Monster other) {
        // Game specific logic...
    }
}