List<User> data =  new ArrayList<String>();
    Connection conn=null;

  try {
        Class.forName(Driver);
        conn = DriverManager.getConnection(URL,"root","");
        String sql ="select * from utilisateur";
        PreparedStatement Stmt = conn.prepareStatement(sql);
        ResultSet rs = Stmt.executeQuery(sql);

        while(rs.next()){
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setNom(rs.getString("nom"));
        user.setPrenom(rs.getString("prenom"));
        user.setCin(rs.getString("cin"));
        user.setAdresse(rs.getString("adresse"));
        user.setTel(rs.getString("tel"));
        user.setDn(rs.getString("dn"));              
        data.add(user);
        }
        rs.close();
        conn.close();

  } catch (ClassNotFoundException ex) {
        System.err.println(ex.getMessage());
  }

  return data;