enum PlayerClass {
    ROGUE(23, 23, 4, ...),
    ...
    ;
    private final int hp;
    PlayerClass(int hp, int atk, ...) {
        this.hp = hp;
        ...
    }
    public int getHp() { return hp; }
    ...
}