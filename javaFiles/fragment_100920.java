private Connection con;

public MySQLConnection() {
    this.connectToDatabase();
}

public void connectToDatabase() { 
    this.con = //connect to db   
}

public void addToDatabase(String tableName, ArrayList<String> columns, ArrayList<String> values) {...}

public void closeConnection() {...}