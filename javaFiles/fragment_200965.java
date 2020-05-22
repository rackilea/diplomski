@Override
public Integer visitGreaterEqual(ExprParser.GreaterEqualContext ctx) {
    int left = this.visit(ctx.expr(0));
    int right = this.visit(ctx.expr(1));

    if (ctx.op.getType() == ExprParser.GREATER) {
        return left > right ? 1 : 0; // 0 is false (all other values are true)
    }
    else {
        return left < right ? 1 : 0;
    }
}