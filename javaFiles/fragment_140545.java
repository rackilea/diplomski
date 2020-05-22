class SomeBee extends Bee {

    boolean isDead() {
        return health <= 0;
    }

    Bee anotherDay() {
        eat();
        return this;
    }
}

for (/* i...size */) {
    Bee bee = cells.get(i);
    if ((bee = bee.anotherDay()).isDead()) {
        dead.add(bee);
    }
    cells.set(i, bee);
}