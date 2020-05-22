public class Whatever{

public static List<Request> getResults(){
String query = "SELECT * FROM request";
List<Request> get_request= new ArrtList<Request>;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                /*String f_name = rs.getString("f_name");
                String l_name = rs.getString("l_name");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                result += (f_name+",.,"+l_name+",.,"+email+",.,"+contact); */

                get_request.add(new Request(rs));
            }
        }
        catch(Exception e){}
        return get_request;

}