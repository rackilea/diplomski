String funcCall = "{? = call schema.mypkg.somefunc(?)}";
Connection conn = ((SessionImpl)em.getDelegate()).connection();
CallableStatement stmt = conn.prepareCall(funcCall);
stmt.setInt(2, 42);
stmt.registerOutParameter(1, Types.CHAR);
stmt.executeUpdate();
String result = stmt.getString(1);