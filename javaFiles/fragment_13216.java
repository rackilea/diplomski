statement = connection.prepareStatement(
            "CREATE TABLE IF NOT EXISTS help" +
                    "(" +
                    "id int not null auto_increment," +
                    "name varchar(20)," +
                    "area varchar(25)," +
                    "date varchar(15)," +
                    "message varchar(255)" +
                    "PRIMARY KEY (id)" +
                    ")");
    statement.execute();