public class Data extends JPanel{

     Connection connection = null;  
     ResultSet resultSet = null;  
     Statement statement = null;  

     static Vector<Vector<String>> data = new Vector<Vector<String>>();

     public void database(){
         try 
         {  
             Class.forName("org.sqlite.JDBC");  
             connection = DriverManager.getConnection("jdbc:sqlite:src//movies.db");  
             statement = connection.createStatement();  
             resultSet = statement.executeQuery("SELECT id, movie_name, movie_category FROM content");

             Vector<String> columnNames = new Vector<String>();
             columnNames.add("id");
             columnNames.add("movie_name");
             columnNames.add("movie_category");

             while (resultSet.next()) 
             {  
                 Vector<String> vString = new Vector<String>();

                 vString.addElement(resultSet.getString("id"));
                 vString.addElement(resultSet.getString("movie_name"));
                 vString.addElement(resultSet.getString("movie_category"));

                 data.add(vString);
             }  
         } //try
         catch (Exception e) 
         {  
             e.printStackTrace();  
         }
         finally 
         {  
             try 
             {  
                 resultSet.close();  
                 statement.close();  
                 connection.close();  
             } 
             catch (Exception e) 
             {  
                 e.printStackTrace();  
             }  
         }
     }


public static void main(String[] args) {
    Data d = new Data();
    d.database();
    System.out.print(d.data);
}