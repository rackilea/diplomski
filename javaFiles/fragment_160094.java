public class ExprWalker extends ExprBaseListener {

  @Override 
  public void enterListener(ExprParser.EXPR_CONTEXTContext ctx) { 

    java.util.List<ExprParser.ExpressionContext> e = ctx.expression();

    System.out.println("EXPRESSION: " //print action
    + e.get(0).getText() + ", " //first element
    + e.get(1).getText() //second element
    + ", " + ... + ", " //number of elements
    + e.get(N).getText()); //last element

}