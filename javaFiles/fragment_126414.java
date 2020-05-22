class PreparedStatementParameters implements InvocationHandler {
    Map<Integer, Object> map = new HashMap<>();
    PreparedStatement ps;

    PreparedStatementParameters(PreparedStatement ps) {
        this.ps = ps;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {

        }
        return method.invoke(proxy, args);
    }

    public void copyParameters(PreparedStatement ps) throws SQLException {
        for (Map.Entry<Integer, Object> e : map.entrySet()) {
            ps.setObject(e.getKey(), e.getValue());
        }
    }
}

public class T2 {
    public static void main(String[] args) throws Exception {
        PreparedStatement ps1 = ...
    PreparedStatementParameters ps1params = new PreparedStatementParameters(ps1);
        PreparedStatement ps1Proxy = (PreparedStatement) Proxy.newProxyInstance(null,
                new Class[] { PreparedStatement.class }, new PreparedStatementParameters(ps1));
        ps1Proxy.setString(1, "test");
        ...
        PreparedStatement ps2 = ...
        ps1params.copyParameters(ps2);
    }
}