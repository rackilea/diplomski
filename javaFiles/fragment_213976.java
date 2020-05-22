IloCplex model = new IloCplex();
...
IloLQNumExpr expr = model.lqNumExpr();

expr.addTerm(x, a, a);
expr.addTerm(x, b, b);
expr.addTerm(-2 * x, a, b);