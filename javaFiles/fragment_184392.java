@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public void postHotel(@FormDataParam("user_name") String userName
                   @FormDataParam("password") String password)
        throws SQLException, FileNotFoundException, IOException {

            stmt.executeUpdate("insert into hotel(user_name,password)values('"
            +userName
            + "','"
            +password
            + "');