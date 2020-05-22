public class RandomClass {
    private Tea tea;

    public RandomClass() {
        tea = new BlackTea();
    }

    public void doStuff() {
        System.out.print("Doing stuff and.. ");
        tea.prepare();
    }    
}