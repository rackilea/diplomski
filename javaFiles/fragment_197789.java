class Animal{}
class Dog extends Animal{}
class AnimalHouse<A extends Animal> {
    List<A> animalsInside = new ArrayList<A>(); 
    void enterHouse(A animal){
        animalsInside.add(A);
    }

    A leaveHouse() {
        return animalsInside.remove(0);
    }
}
AnimalHouse<Dog> ah = new AnimalHouse<Dog>();
ah.enterHouse(new Dog());
Dog rufus = ah.leaveHouse();