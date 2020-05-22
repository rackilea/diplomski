DB2400Dialect

@Override
public IdentityColumnSupport getIdentityColumnSupport() {
    return new DB2390IdentityColumnSupport();
}

...

public class DB2390IdentityColumnSupport extends DB2IdentityColumnSupport {
    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select identity_val_local() from sysibm.sysdummy1";
    }
}