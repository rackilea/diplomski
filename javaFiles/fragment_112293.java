String instruccionSql = "INSERT INTO USERS (nombre, apellido, usuario, contra, pais, tecno) VAlUES (?,?,?,?,?,?)";

PreparedStatement ps = miConexion.prepareStatement(instruccionSql);
ps.setString(1, nombre);
ps.setString(2, apellido);
ps.setString(3, usuario);
ps.setString(4, contra);
ps.setString(5, pais);
ps.setString(6, tecnoStr);

ps.executeUpdate();