public class UserDAOImpl implements UserDAO{
    public List<User> readUser() {
        List<User> list = new ArrayList();
        User u = new User();
        try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", ""); 
        Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery("select * from user");){
        System.out.println("inside readuser impl");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                u.setId(id);
                u.setName(name);
                u.setAddress(address);
                System.out.println(u);
                list.add(u); //adding user object to list
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list; //returning to list for json response
        }
     }