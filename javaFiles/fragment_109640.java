public void markMiss() {
    this.status = MISSED;
    setShip(false);
}

public void markHit() {
    this.status = HIT;
    setShip(true);
}

public boolean checkMiss() {
    return this.status == MISSED;
}

public boolean checkHit() {
    return this.status == HIT;
}

public boolean setShip(boolean val) {
    this.hasAShip = val;
}

public boolean hasShip() {
    return this.hasAShip;
}