class ToChar extends CustomField<String> {
    final Field<?> arg0;
    final Field<?> arg1;
    ToChar(Field<?> arg0, Field<?> arg1) {
        super("to_char", SQLDataType.VARCHAR);
        this.arg0 = arg0;
        this.arg1 = arg1;
    }
    @Override
    public void toSQL(RenderContext context) {
        context.visit(delegate(context.configuration()));
    }
    @Override
    public void bind(BindContext context) {
        context.visit(delegate(context.configuration()));
    }
    private QueryPart delegate(Configuration configuration) {
        switch (configuration.dialect().family()) {
            case ORACLE:
                return DSL.field("TO_CHAR({0}, {1})", 
                    String.class, arg0, arg1);

            case SQLSERVER:
                return DSL.field("CONVERT(VARCHAR(8), {0}, {1})", 
                    String.class, arg0, arg1);

            default:
                throw new UnsupportedOperationException("Dialect not supported");
        }
    }
}