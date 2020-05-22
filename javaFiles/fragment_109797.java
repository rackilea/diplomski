public class Parent extends Thread {

    private Dish dish;

    public Parent (Dish dish) {
        this.dish = dish;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            dish.waitForEmptyToFill();
        }
        dish.setShutDown(true);
    }
}