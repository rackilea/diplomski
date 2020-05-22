interface Expression {
  Number compute();
}

class AtomicExpression implements Expression {
  private final Number number;
  AtomicExpression(Number number) {
    this.number = number;
  }
  public Number compute() {
    return number;
  }
}

class BinaryExpression implements Expression {
  private final Expression expr1;
  private final Expression expr2;
  private final Operator op;
  AtomicExpression(Expression expr1, Expression expr1. Operator op) {
    this.expr1 = expr1;
    this.expr2 = expr2;
    this.op = op;
  }
  public Number compute() {
    return op(expr1.compute(), expr2.compute());
  }
}