public class RandomClass {
    private Tea tea;

    @Inject public RandomClass(Tea tea) {
        this.tea = tea;
    }

    public void doStuff() {
        System.out.print("Doing stuff and.. ");
        tea.prepare();
    }    
}

// Guice writes Provider<RandomClass> automatically.