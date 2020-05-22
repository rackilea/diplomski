public abstract class Spell {
    private String name;
    private Sorcerer sorcerer;
    public Sorcerer getSorcerer() {
        return sorcerer;
    }
    public abstract void cast(Target... targets);
}