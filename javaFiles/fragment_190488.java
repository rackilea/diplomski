class Widget {
    private final WidgetCalculator calculator;

    public Widget(WidgetCalculator calculator) {
        this.calculator = calculator;
    }

    public void DoSomething() {
        int someValue = this.calculator.calculate();
        // and so on...
    }
}