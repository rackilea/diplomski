@Override
public boolean equals(Traffic t) {
    return this.attacker.equals(t.getAttacker()) && 
        this.victim.equals(t.getVictim()) && 
        this.date == t.getDate();
}