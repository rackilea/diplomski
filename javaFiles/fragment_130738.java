class Animal {
    private final int lifeSpan;

    public Animal() {
        // Default to a life-span of 50
        this(50);
    }

    public Animal(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getName(){
        return "Animal";
    }

    public int getLifeSpan() {
        return lifeSpan;
    }
}

class Elephant extends Animal {
    public Elephant() {
        // Give every elephant a life-span of 100.
        super(100);
    }

    @Override public String getName() {
        return "Elephant";
    }
}

public class Test {
    public static void main(String args[]){
        Animal animal = new Elephant();
        System.out.printf("I am an %s and I live around %d years%n",
            animal.getName(), animal.getLifeSpan());
    }
}