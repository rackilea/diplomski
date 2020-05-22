class Animal {
    private String animalName;
    public Animal(String name) {
        animalName = name;
    }
    public getName() { return animalName; }

    public class Eagle extends Animal {
        public Eagle() {
            super("Eagle");
        }
        public void foo() {
            animalName = animalName + "!";
        }
    }
}