public MyClass(String input) {
        this(new InitCalcResult(input));
    }

    private MyClass(InitCalcResult initCalcResult) {
        super(initCalcResult.initB + initCalcResult.initC);
        this._a = initCalcResult.initA;
        this._b = initCalcResult.initB;
        this._c = initCalcResult.initC;
    }

    private static class InitCalcResult {
        private int initA, initB, initC;

        InitCalcResult(String input) {
            initA = calculateA(input);
            initB = calculateB(initA);
            initC = calculateC(initA);  
        }
    }