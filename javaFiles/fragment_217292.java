public class Main {

  public static void main(String[] args) throws Exception {

    Map<String, Object> variables = new HashMap<String, Object>() {{
      put("A", true);
      put("a", true);
      put("B", false);
      put("b", false);
      put("C", 42.0);
      put("c", 42.0);
      put("D", -999.0);
      put("d", -1999.0);
      put("E", 42.001);
      put("e", 142.001);
      put("F", 42.001);
      put("f", 42.001);
      put("G", -1.0);
      put("g", -1.0);
    }};

    String[] expressions = {
        "1 > 2",
        "1 >= 1.0",
        "TRUE = FALSE",
        "FALSE = FALSE",
        "A OR B",
        "B",
        "A = B",
        "c = C",
        "E > D",
        "B OR (c = B OR (A = A AND c = C AND E > D))",
        "(A = a OR B = b OR C = c AND ((D = d AND E = e) OR (F = f AND G = g)))"
    };

    for (String expression : expressions) {
      SimpleBooleanLexer lexer = new SimpleBooleanLexer(new ANTLRInputStream(expression));
      SimpleBooleanParser parser = new SimpleBooleanParser(new CommonTokenStream(lexer));
      Object result = new EvalVisitor(variables).visit(parser.parse());
      System.out.printf("%-70s -> %s\n", expression, result);
    }
  }
}

class EvalVisitor extends SimpleBooleanBaseVisitor<Object> {

  private final Map<String, Object> variables;

  public EvalVisitor(Map<String, Object> variables) {
    this.variables = variables;
  }

  @Override
  public Object visitParse(SimpleBooleanParser.ParseContext ctx) {
    return super.visit(ctx.expression());
  }

  @Override
  public Object visitDecimalExpression(SimpleBooleanParser.DecimalExpressionContext ctx) {
    return Double.valueOf(ctx.DECIMAL().getText());
  }

  @Override
  public Object visitIdentifierExpression(SimpleBooleanParser.IdentifierExpressionContext ctx) {
    return variables.get(ctx.IDENTIFIER().getText());
  }

  @Override
  public Object visitNotExpression(SimpleBooleanParser.NotExpressionContext ctx) {
    return !((Boolean)this.visit(ctx.expression()));
  }

  @Override
  public Object visitParenExpression(SimpleBooleanParser.ParenExpressionContext ctx) {
    return super.visit(ctx.expression());
  }

  @Override
  public Object visitComparatorExpression(SimpleBooleanParser.ComparatorExpressionContext ctx) {
    if (ctx.op.EQ() != null) {
      return this.visit(ctx.left).equals(this.visit(ctx.right));
    }
    else if (ctx.op.LE() != null) {
      return asDouble(ctx.left) <= asDouble(ctx.right);
    }
    else if (ctx.op.GE() != null) {
      return asDouble(ctx.left) >= asDouble(ctx.right);
    }
    else if (ctx.op.LT() != null) {
      return asDouble(ctx.left) < asDouble(ctx.right);
    }
    else if (ctx.op.GT() != null) {
      return asDouble(ctx.left) > asDouble(ctx.right);
    }
    throw new RuntimeException("not implemented: comparator operator " + ctx.op.getText());
  }

  @Override
  public Object visitBinaryExpression(SimpleBooleanParser.BinaryExpressionContext ctx) {
    if (ctx.op.AND() != null) {
      return asBoolean(ctx.left) && asBoolean(ctx.right);
    }
    else if (ctx.op.OR() != null) {
      return asBoolean(ctx.left) || asBoolean(ctx.right);
    }
    throw new RuntimeException("not implemented: binary operator " + ctx.op.getText());
  }

  @Override
  public Object visitBoolExpression(SimpleBooleanParser.BoolExpressionContext ctx) {
    return Boolean.valueOf(ctx.getText());
  }

  private boolean asBoolean(SimpleBooleanParser.ExpressionContext ctx) {
    return (boolean)visit(ctx);
  }

  private double asDouble(SimpleBooleanParser.ExpressionContext ctx) {
    return (double)visit(ctx);
  }
}