class Operation {

    Runnable operation = null;

    private int result;
    private int op1;
    private int op2;

    public Example(int op1, int op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    // ... more code ...

    Runnable sum = new Runnable() {
        public void run() { result = op1 + op2; }
    }

    Runnable minus = new Runnable() {
        public void run() { result = op1 - op2; }
    }

    // ... more code ...

    public void selectBehaviour(String behaviourName) {

        // ... more code ...

        // select behaviour
        if("SUM".equals(behaviourName)) {
            operation = sum;
        } else if("MINUS".equals(behaviourName)) {
            operation = minus;
        } else {
            // ... more code ...
        }

    }

    public void perform() {
        operation.run();
    }

    int getResult() {
        return result;
    }
}