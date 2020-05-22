public class AnimalNoise {}
public class Miaw extends AnimalNoise {}

public class Animal {
    public AnimalNoise makeNoise() {
        return new AnimalNoise();
    }
}

public class Cat extends Animal {
    public Miaw makeNoise() {
        return new Miaw ();
    }
}