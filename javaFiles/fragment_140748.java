JForLoop forLoop = body._for();
JVar ivar = forLoop.init(codeModel.INT, "i", JExpr.lit(0));
forLoop.test(ivar.lt(JExpr.lit(42)));
forLoop.update(ivar.assignPlus(JExpr.lit(1)));

forLoop.body().add(
    codeModel.ref(System.class).staticRef("out").invoke("println").arg(ivar));