@Override
public void adduser(User usr){
     String req="INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `password`, `roles`, `nom`) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

     try {
        PreparedStatement stm = connection.prepareStatement(req);

        stm.setInt(1, user.getId());
        stm.setString(2, user.getUsername());
        stm.setString(3, user.getUsername_canonical());
        ...

        stm.executeUpdate();//execute your statement
        System.out.println("ajout ok");
    } catch (SQLException ex) {
    }