Operator factorial = new Operator("!", 2, true, Operator.PRECEDENCE_POWER + 1) {
  @Override public double apply(double... args) {
    final long arg = (long) args[0];
    if ((double) arg != args[0]) {
      throw new IllegalArgumentException("Operand for factorial has to be an integer");
    }
    if (arg < 0) {
      throw new IllegalArgumentException("The operand of the factorial can not " +
      "be " +
      "less than zero");
    }
    double result = 1;
    for (int i = 1; i <= arg; i++) {
      result *= i;
    }
    return result;
  }
};