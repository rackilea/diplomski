DoubleProperty x = new SimpleDoubleProperty(3);
DoubleProperty y = new SimpleDoubleProperty(4);

DoubleBinding hyp = new DoubleBinding() {
    {
        bind(x);
        bind(y);
    }

    @Override
    protected double computeValue() {
        System.out.println("Computing distance");
        return Math.sqrt(x.get()*x.get() + y.get()*y.get());
    }
};

Label hypLabel = new Label();
hypLabel.textProperty().bind(hyp.asString("Hypotenuse: %f"));