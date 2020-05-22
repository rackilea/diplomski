public abstract class AbstractFormula {

    protected abstract void initialize();

    public double evaluate() {
        initialize();
        //
        // do the logic
        //
        return 0d; // the result
    }
}