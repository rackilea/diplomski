String mySql = "DECLARE x NUMBER; BEGIN "
        + "  insert  into Usuario(DOCUMENTOIDENTIDAD,NOMBRE,CARGO,CONTRASENA,PERMISO) "
        + "  values (?,?,?,?,?) "
        + "  RETURNING ID INTO x;"
        + "  ? := x;"
        + "END; ";
CallableStatement cal = conn.prepareCall(mySql);

cal.setString(1, "22323");
cal.setString(2, "asfa");
cal.setString(3, "Administrador");
cal.setString(4, "123456");
cal.setString(5, "0");
cal.registerOutParameter(6, java.sql.Types.INTEGER);

cal.executeQuery();

Integer newId = cal.getInt(6);