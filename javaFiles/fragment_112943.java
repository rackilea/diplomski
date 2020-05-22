public abstract class Animal {
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public getName() { return name; }
    public getBreed() { return breed; }

    public abstract void moving();
}

public class Dog extends Animal {
    public Dog(String name, String breed) {
        super(name, breed);
    }

    @Override
    public void moving(){
        System.out.print("Walks\n");
    }
}

public class Fish extends Animal {
    public Fish(String name, String breed) {
        super(name, breed);
    }

    @Override
    public void moving(){
        System.out.print("Swims\n");
    }
}