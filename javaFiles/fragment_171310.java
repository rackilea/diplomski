public class MyOracle10gDialect extends Oracle10gDialect {
    public MyOracle10gDialect() {
        super();
    }
    protected void registerNumericTypeMappings() {
        super.registerNumericTypeMappings();
        registerColumnType( Types.DOUBLE, "float" );
    }
}