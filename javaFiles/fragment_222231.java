public abstract class Animal {
    protected String noise;

    protected Animal(String noise) {
        this.noise = noise;
    }

    public void makeNoise() {
        System.out.println(noise);
    }

}

public class Cat extends Animal{
    public static final String NOISE = "meow";

    public Cat() {
        super(NOISE);
    }
}