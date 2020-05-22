class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public void method() {

        List<Dog> dogs = new ArrayList<Dog>();

        addCats(dogs);
    }

    void addCats(List<? extends Animal> list) {
        list.add(new Cat());
    }