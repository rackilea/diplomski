<% 
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/app?user=root&password=12345");

                Statement statement = connection.createStatement();

                String pub_id = request.getParameter("pub_id);  

                ResultSet resultset = 
                    statement.executeQuery("select * from publishers where id = '" + pub_id+ "'") ; 

                if(!resultset.next()) {
                    out.println("Sorry, could not find that publisher.Please enter a valid ID. <a href='viewPublishers'>Try Again.</a> ");
                } else {
            %>




  <table>
              <thead>
  <tr>
    <th>Publisher ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Books</th>
</thead>


<tbody style="font-size:small;">
  <tr>
    <td data-label="Publiser ID"><%= resultset.getString("pub_id") %></td>
    <td data-label="First Name"><%= resultset.getString("first_name") %></td>
    <td data-label="Last Name"><%= resultset.getString("last_name") %></td>
    <td data-label="Books"><%= resultset.getString("books") %>

 </tr>
                </tbody>
</table>

<div>   <% 
           } 
       %></div>