public class Ross extends PircBot {

    private Connection conn;


    public Ross() {

            this.setName("RICK_ROSS");
            this.setVersion("v1.0");
            this.setLogin("not_a_bot");
            if (!main.password.equals("")) this.sendMessage(main.loginbot, "auth "+main.username+" "+main.password);

            //Set up MySQL-connection
            Connection conn = null;
            String url = "jdbc:mysql://";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url,"","");
    }
    ...The rest...