import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/my_database", "db_user", "db_password");

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM my_table");
            HashMap<String, DBRecord> results = new HashMap<>();
            while (resultSet.next()) {
                results.put(resultSet.getString(1), new DBRecord(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
            connection.close();
            printHashMap(results);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void printHashMap(HashMap<String, DBRecord> records) {
        for (Map.Entry pair : records.entrySet()) {
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    public static class DBRecord {

        private String ip, instance;
        private double firstValue;
        private int secondValue, thirdValue;

        public DBRecord(String ip, String instance, double firstValue, int secondValue, int thirdValue) {
            this.ip = ip;
            this.instance = instance;
            this.firstValue = firstValue;
            this.secondValue = secondValue;
            this.thirdValue = thirdValue;
        }

        //Gets and sets...

        @Override
        public String toString() {
            return ip + " | " + instance + " | " + firstValue + " | " + secondValue + " | " + thirdValue;
        }
    }

}