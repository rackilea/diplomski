interface PlayerClass {
    int getBaseHp();
    int getBaseAtk();
    ... // more class attributes
}

// as utility so I don't have to write 20 full classes
abstract class PlayerClassBase implements PlayerClass {
    private final int hp, atk, ..;
    protected PlayerClassBase(int hp, int atk, ...) {
        this.hp = hp;
        this.atk = atk;
    }
    @Override
    public int getBaseHp() {
        return hp;
    }
    ....
}

// short class but guaranteed that every instance of Rogue has the correct values
class Rogue {
     public Rogue() {
         super(40, 23, 123, ...);
     }
}

// something to represent entities
interface Entity {
    int getCurrentHp();
    int takeDamageFrom(Entity other);
    ...
}

// maybe an abstract base class here as well

// represents a player that has an immutable class and it can't exist without
class Player implements Entity {
    privte final PlayerClass playerClass;
    private int currentHp;
    ...

    public Player(PlayerClass playerClass) {
        this.playerClass = playerClass;
        currentHp = playerClass.getHp();
        ...
    }
    public int takeDamageFrom(Entity other) {
        currentHp -= other.getCurrentAtk();
        return currentHp;
    }

}