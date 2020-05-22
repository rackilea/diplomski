interface Ability {
    void doAbility();
}

class Firebending implements Ability {
    private Mob mob;

    public Firebending(Mob mob) {
        this.mob = mob;
    }

    void doAbility() {
        // mutate mob's state to spit fire, and attack the world
    }
} // repeat this for each ability you have, flying, x-ray vision, doing taxes etc

class Mob {
    private Ability[] abilities;

    public Mob(Ability[] abilities) {
        this.abilities = abilities;
    }
}