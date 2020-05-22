User usr = new User();    

Url url;
HttpURLConnection conn;
ObjectOutputStream objout;
try {
    url = new Url("http://192.160.1.1");
    conn  = (HttpURLConnection) url.getConnection();

    conn.setDoOutput(true); //this is to enable writing
    conn.setDoInput(true);  //this is to enable reading

    out = new ObjectOutputStream(conn.getOutputStream());
    out.writeObject(usr);
    out.close();
}