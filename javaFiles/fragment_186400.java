public class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("wuff wuff");
    }

    public String getName() {
        return "John";
    }
}