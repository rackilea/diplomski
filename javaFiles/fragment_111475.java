public class Car {

    static class CarConfig {
        int x;
        int y;

        CarConfig(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final Engine engine;

    public Car(int x, int y) {

      this(new CarConfig(x, y));
    }

    Car(CarConfig config) {
         this.engine = createEngine(config);
    }

    protected Engine createEngine(CarConfig config) {
         return new Engine(config.x ,config.y);
    }
}