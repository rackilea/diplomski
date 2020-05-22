@POST
@Path("/login/{id}")
@Consumes("application/xml")
public StreamingOutput login(@PathParam("id") int id, InputStream is) {
    String login[] = null;
    ObjectInputStream ois = null;
    try {
        ois = new ObjectInputStream(is);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        login = (String[]) ois.readObject();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    this.login[0] = login[0];
    this.login[1] = login[1];
    return new StreamingOutput() {
        public void write(OutputStream outputStream) throws IOException,
                WebApplicationException {
            login(outputStream);
        }
    };
}
public void login(OutputStream os) {
    boolean result = false;
    connect();
    ResultSet rs = null;
    try {
        PreparedStatement ps = dbconn
                .prepareStatement("Select password from supervisor where username = '"
                        + login[0] + "'");
        rs = ps.executeQuery();
        rs.next();
        String password = rs.getString("password");
        login[0] = password;
        if (login[1].equals(password)) {
            result = true;
        }
    } catch (SQLException e) {
        login[0] = e.toString();
    }
    try {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(result);
        oos.writeObject(login);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}