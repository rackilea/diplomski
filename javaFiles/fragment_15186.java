class Hero extends Actor {
    // update logic in act()
    // render sprite in draw() depending on the this.getX()/getY()
}

class Weapon extends Actor {
    // update logic in act()
    // render sprite in draw() depending on the this.getX()/getY()
}

class Character extends Group {
    private Hero hero;
    private Weapon weapon;

    public Character(Hero hero, Weapon weapon) {
        this.hero = hero;
        this.weapon = weapon;
        addActor(hero);
        addActor(weapon);
        weapon.setPosition(10f, 0f); // small offset to the right
    }
}