public class Risp {
    private int baseattack, basespeed; // ... and so on
    // also have a constructor that sets all base stats

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getSpecies() {
        return "Risp";
    }
    public int getAttack() {
        return (int) (baseattack+.2*4*strength+strength);
    }
    // remaining setters & getters omitted
}