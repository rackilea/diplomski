public int decreaseHitPoints(Fighter fighterTwo) {
    this.fighterTwo = fighterTwo;
    int health = fighterTwo.getHealth();
    int attack = getAttack();
    health = health - attack;
    return health;
}