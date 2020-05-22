try {
    Class.forName("org.sqlite.JDBC");
} catch (ClassNotFoundException ex) {
    Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
}
connection = DriverManager.getConnection("jdbc:sqlite:D:\\new.db");

for(i = 0; i < 260; i++)
{
    java.sql.Statement statement = connection.createStatement();
    try {
        statement.executeUpdate("INSERT INTO suggestion (suggesting) VALUES('"+words[i]+"')");
    } finally {
        // Statements, like connections, also need to be closed after use
        statement.close();
    }
    System.out.println(i + " - " + words[i]);
}