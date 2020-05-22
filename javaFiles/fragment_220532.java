public abstract class Animal {
    private int hunger;

    public Animal() {
        this(0);
    }

    public Animal(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger(){
        return this.hunger;
    }

    abstract void talk();
}