DoubleProperty x = new SimpleDoubleProperty(3);
DoubleProperty y = new SimpleDoubleProperty();
final double factor = 1.2;

BidirectionalBinding<Number, Number> binding = new BidirectionalBinding<>(x, y) {

    @Override
    protected Number convert(Number value) {
        return value.doubleValue() * factor;
    }

    @Override
    protected Number inverseConvert(Number value) {
        return value.doubleValue() / factor;
    }

};

System.out.printf("x = %f; y = %f\n", x.get(), y.get());
x.set(5);
System.out.printf("x = %f; y = %f\n", x.get(), y.get());
y.set(15);
System.out.printf("x = %f; y = %f\n", x.get(), y.get());