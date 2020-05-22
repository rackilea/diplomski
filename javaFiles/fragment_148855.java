@Override
public void sql(BindingSQLContext<Polygon> ctx) throws SQLException {
    ctx.render()
       .sql("ST_GeomFromText(")
       // This will use your converter to convert from a Polygon to "Object"
       // prior to binding the variable
       .visit(DSL.val(ctx.convert(converter()).value()))
       .sql(")");
}


@Override
public void set(BindingSetStatementContext<Polygon> ctx) throws SQLException {
    // No wrapping of the bind variable in functions can be done here!
    ctx.statement().setString(ctx.index(), ctx.convert(converter()).value());
}