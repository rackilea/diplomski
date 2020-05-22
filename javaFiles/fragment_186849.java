public static void main(String[] args) {
    final DoubleProperty amount = new SimpleDoubleProperty(100_000.00);
    final DoubleProperty part = new SimpleDoubleProperty();
    final DoubleProperty rate = new SimpleDoubleProperty();

    part.addListener(new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
            System.out.println("part is invalid");
            rate.set(part.get() / amount.get());
        }
    });

    rate.addListener(new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
            System.out.println("rate is invalid");
            part.set(rate.get() * amount.get());
        }
    });

    System.out.println("setting rate");
    rate.set(0.025);
    System.out.println("Part: " + part.get()); //2500

    System.out.println("setting part");
    part.set(1200);
    System.out.println("Rate: " + rate.get()); //0.012
}