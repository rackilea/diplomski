@FunctionName("HttpTrigger-Java")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context)  {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);




        return request.createResponseBuilder(HttpStatus.OK).body("Hello" + QuerySQl()).build();


    }

   public String QuerySQl(){



       String hostName = ".database.windows.net"; // update me
        String dbName = ""; // update me
        String user = ""; // update me
        String password = ""; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;"
                + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        //System.out.print(url);
        Connection connection;
        PreparedStatement st = null;
        String result="";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            String sql = "select * from dbo.Colors where value = ?";
            st = connection.prepareStatement(sql);
            st.setString(1, "test");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {

                result = "id:" + resultSet.getString(1) + "\tvalue: " + resultSet.getString(2) +"\n";


            }

            connection.close();
        }catch(Exception e){

            e.printStackTrace();

        }
       return result;
   }