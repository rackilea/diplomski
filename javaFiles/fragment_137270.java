UUID u = UUID.randomUUID();
Statement st = MySQL.createStatement();
st.executeUpdate("INSERT INTO `game_info` (`uuid`) VALUES ('" + u.toString() + "'");");
ResultSet res = st.executeQuery("SELECT `id_int` FROM `game_info` WHERE `uuid`='" + u.toString() + "';");
res.next();
int id = res.getInt("id_int");