public class FastEngine extends Engine {

    public FastEngine(int x, int y, double a, double b) {
        super(x, y);
        // (...)
    }

    // (...)
}

public class FastCar extends Car {

    static class FastCarConfig extends CarConfig {
         double a;
         double b;

         FastCarConfig(int x, int y, double a, double b) {
             super(x, y);
             this.a = a;
             this.b = b;
         }
     }


    private final double a;
    private final double b;

    public FastCar(int x, int y, double a, double b) {
        super(new FastCarConfig(x, y, a, b);
        this.a = a;
        this.b = b;
    }

    @Override
    protected Engine createEngine(CarConfig config) {
        if (config instanceof FastCarConfig) throw new IllegalStateException("You messed up!");
        FastCarConfig c = (FastCarConfig) config;
        return new FastEngine(c.x, c.y, c.a, c.b);
    }
}