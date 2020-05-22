public class MathApplication {
    
    private CalculatorService calcService;

    @Autowired
    public void setCalcService(final CalculatorService calcService) {
        this.calcService = calcService;
    }

    public double add(final double input1,
                      final double input2) {
        return this.calcService.add(input1, input2);
    }

    public double substract(final double input1,
                            final double input2) {
        return this.calcService.substract(input1, input2);
    }
}