String sql = ""SELECT * FROM Usuarios WHERE Usuario='"+fUser+"' AND Pass='"+fPass+"'"";
System.out.println("sql: " + sql); //check that in a sql-tool against your db if it works as expected.
ResultSet rs = st.executeQuery(sql);

while (rs.next()) { 
    System.out.println("fUser: " + fUser);
    System.out.println("fPass: " + fPass);
    System.out.println("usuario: " + rs.getString("Usuario"));
    System.out.println("pass: " + rs.getString("Pass"));
    System.out.println("check #1: " + fUser.equalsIgnoreCase(rs.getString("Usuario")));
    System.out.println("check #2: " + fPass.equalsIgnoreCase(rs.getString("Pass")));

    if (fUser.equalsIgnoreCase(rs.getString("Usuario")) && fPass.equalsIgnoreCase(rs.getString("Pass"))) {
        response.sendRedirect("index.jsp");
    } else {
        out.print("Usuario Invalido");
    }
}
System.out.println("end of while");