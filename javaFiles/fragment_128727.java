public static void main(String[] args) {
    String x="20,10,\"*\"";
    System.out.println(x+"="+Expr.exprEval(x));
     x="20,10,\"+\"";
    System.out.println(x+"="+Expr.exprEval(x));
     x="20,10,\"-\"";
    System.out.println(x+"="+Expr.exprEval(x));
    x="20,10,\"/\"";
    System.out.println(x+"="+Expr.exprEval(x));
}