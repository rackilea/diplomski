package kitchen;

import java.util.ArrayList;
import java.util.List;

class Food{}
class Bamboo extends Food {}

interface Kitchen<F> {
    void build(List<F> dessert);
}

abstract class Restaurant<T> {
    protected Kitchen kitchen;

    Restaurant(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    List<T> getMeals() {
        List<T> food = new ArrayList<>();
        kitchen.build(food);
        return food;
    }
}

class PandaKitchen implements Kitchen<Bamboo>{

    @Override
    public void build(List<Bamboo> dessert)
    {
        dessert.add(new Bamboo());
    }
}

/** Bamboo specialized restaurant*/
class OhPanda extends Restaurant<Bamboo> {

    OhPanda() {
        super(new PandaKitchen());
    }

    @Override
    List<Bamboo> getMeals() {
        List<Bamboo> bamboos = new ArrayList<>();
        kitchen.build(bamboos);
        return bamboos;
    }
}