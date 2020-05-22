public class Animal {
    public String makeNoise() {
        return "silence";
    }
}

public class Cat extends Animal {
    public Miaw makeNoise() {
        return new Miaw ();
    }
}
public class Miaw {}