public static void main(String[] args){
    JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 Connection conn = null;

   try {


// The driver allows you to query the database with Java
        // forName dynamically loads the class for you


   Class.forName("com.mysql.jdbc.Driver");

            // DriverManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database
            // You must also pass the userid and password for the database
 conn = DriverManager.getConnection(" path where your database is, plus put your username and password");

            // Statement objects executes a SQL query
            // createStatement returns a Statement object
 Statement sqlState = conn.createStatement();

            // This is the query I'm sending to the database

           String selectStuff = "select b.yearID, b.playerID from Student;