public List<Connections> Connections() {
    String sql = "SELECT name , pass , ip , port , dbName , dbType FROM connections";

    try(Connection conn = this.connect(); 
        Statement stmt = conn.createStatement()
        ResultSet rsc = stmt.executeQuery(sql)) {
        List<Connections> list = new ArrayList<>();
        while(rsc.next()){
            list.add(new Connections(
                rsc.getString("name"),
                rsc.getString("pass"),
                rsc.getInt("ip"),
                rsc.getInt("port"),
                rsc.getString("dbName"),
                rsc.getInt("dbType")
            ));
        }
        return list;
    } catch (SQLException ex) {
        System.out.println("Conns error " + ex);
        return new ArrayList<>();
    }
}