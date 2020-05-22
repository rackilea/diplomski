class Medic {
    public int phystrength, restoring;
    boolean isAvailable; // true/false makes more sense than "busy" / "available"

    public Medic (int strength, int restoring, boolean available) {
        this.phystrength = strength;
        this.restoring = restoring;
        this.isAvailable = available;
    }
}