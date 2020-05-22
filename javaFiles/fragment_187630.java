public class ImprovedHSQLDialect extends HSQLDialect {

    public ImprovedHSQLDialect() {
        super();
        registerKeyword("true");
        registerKeyword("false");
        registerKeyword("unknown");
    }
}