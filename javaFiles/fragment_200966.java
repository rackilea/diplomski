@Override
public Integer visitWhile(ExprParser.WhileContext ctx) {

    // Evaluate the relational expression and continue the while
    // loop as long as it is true (does not equal zero).
    while (this.visit(ctx.relational()) != 0) {

        // Evaluate all statements inside the while loop.
        for (ExprParser.StatContext stat : ctx.stat()) {
            this.visit(stat);
        }
    }

    // 0 now also is false, so maybe return null instead which would be
    // some sort of VOID value (or make a proper Value class).
    return 0;
}