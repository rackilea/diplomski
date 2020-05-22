public class RandomClass {
    private Tea tea;

    public RandomClass(Tea tea) {
        this.tea = tea;
    }

    public void doStuff() {
        System.out.print("Doing stuff and.. ");
        tea.prepare();
    }    
}

public class RandomClassProvider {
    public RandomClass create() {
        return new RandomClass(new BlackTea());
    }
}