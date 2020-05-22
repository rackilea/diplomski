public abstract class DecisionFunctionJ {
    public abstract double evaluate();

    public DecisionFunctionJ add(final DecisionFunctionJ another) {
        return new DecisionFunctionJ() {
            @Override
            public double evaluate() {
                return DecisionFunctionJ.this.evaluate() + another.evaluate();
            }
        };
    }
}