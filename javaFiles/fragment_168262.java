public class mysqlquery extends Conexion{
 Connection con = null;
 private String userRole;

 public String getUserRole() { return userRole; }

    public boolean autenticacion(String name, String  password){
        PreparedStatement pst = null;
        //PreparedStatement pst1=null;
        ResultSet rs = null;
        //ResultSet rs1 = null;
        try {
            String query= "select * from person where name= ? and pass = ?";
            pst = getConexion().prepareCall(consulta);
            pst.setString(1, user);
            pst.setString(2, password); 
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                userRole = rs.getString("role");
                return true;
            }
        } catch (Exception e) {
            System.err.println("error: "+e);
        }
        return false;
    }