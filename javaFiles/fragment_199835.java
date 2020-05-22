@Override
public boolean equals(Object o) {
    if (!(o instanceof Traffic)) {
        return false;
    }

    Traffic t = (Traffic) o;

    return Objects.equals(attacker, t.attacker) &&
        Objects.equals(victim, t.victim) &&
        date == t.date;
}