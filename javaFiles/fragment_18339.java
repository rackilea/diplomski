/**
 * reduce this bears stamina by the given amount
 */
public void reduceStamina(int reduction) {
    setStamina(getStamina() - reduction);
}

public void isDead() {
    return getStamina() < 0;
}

public void attack(Bear otherBear) {
    otherBear.reduceStamina(50);
    if(otherBear.isDead()) {
        this.victoryDance();
    }
}