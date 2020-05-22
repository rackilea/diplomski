public class Skills {
    private int vehicleSkill;
    private int hackingSkill;
    // etc.

    public Skills(Random r) {
        this.vehicleSkill = r.nextInt(125)+25;
        this.hackingSkill = r.nextInt(125)+25;
        // etc.
    }

    public int getVehicleSkill() {
        return vehicleSkill;
    }

    public int getHackingSkill() {
        return hackingSkill;
    }

    // etc.
}