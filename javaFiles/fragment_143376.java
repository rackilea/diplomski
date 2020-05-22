import java.sql.*;

public class TestSql {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            try {
                System.out.println("Buscando el driver JDBC...");
                Class.forName("com.mysql.jdbc.Driver"
                // "org.postgresql.Driver"
                        // "oracle.jdbc.driver.OracleDriver"
                        // "com.microsoft.sqlserver.jdbc.SQLServerDriver"
                        // "org.firebirdsql.jdbc.FBDriver"
                        ).newInstance();
                System.out.println("...Encontró el driver JDBC");
            } catch (Exception e) {
                System.out.println("No pudo encontrar el driver JDBC !!!!");
                e.printStackTrace(System.out);
                return;
            }
            try {
                System.out.println("Connectando a la base de datos...");
                con = DriverManager
                        .getConnection("jdbc:mysql://localhost/curso?user=curso&password=123"
                        // "jdbc:postgresql://localhost/curso:5432","postgres","123"
                        // "jdbc:oracle:thin:@192.168.0.10:1521/XE","curso","123"
                        // "jdbc:sqlserver://192.168.0.100:1433/database=curso/user=curso/password=123"
                        // "jdbc:firebirdsql:127.0.0.1:C:/firebird/data/curso.gdb","curso","123"
                        );
                System.out.println("...Connectado a la base de datos");
            } catch (Exception e) {
                System.out
                        .println("No pudo conectarse a la base de datos !!!!");
                e.printStackTrace(System.out);
                return;
            }
            try {
                System.out
                        .println("Lista de empleados con salario inferior a $30,000");
                s = con.createStatement();
                rs = s
                        .executeQuery("select concat(first_name,' ',last_name) as full_name from employee where salary < 30000");
                // "select first_name||' '||last_name as full_name from employee where salary < 30000");
                while (rs.next()) {
                    System.out.println(rs.getString("full_name"));
                }
            } catch (java.sql.SQLException e) {
                System.out.println("Unable to step thru results of query");
                showSQLException(e);
                return;
            }
            try {
                System.out
                        .println("===============================================");
                System.out
                        .println("Lista de empleados con salario entre $30,000 y $40,000");
                ps = con
                        .prepareStatement("select concat(first_name,' ',last_name) as full_name from employee where salary between ? and ?");
                // "select first_name||' '||last_name as full_name from employee where salary between ? and ?");
                ps.setInt(1, 30000);
                ps.setInt(2, 40000);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("full_name"));
                }
            } catch (java.sql.SQLException e) {
                System.out.println("Unable to submit a static SQL query.");
                showSQLException(e);
                return;
            }
        } finally {
            System.out.println("Cerrando la conexion a la base de datos.");
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (java.sql.SQLException e) {
                showSQLException(e);
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (java.sql.SQLException e) {
                showSQLException(e);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (java.sql.SQLException e) {
                showSQLException(e);
            }
            System.out.println("Fin");
        }
    }

    private static void showSQLException(java.sql.SQLException e) {
        java.sql.SQLException next = e;
        while (next != null) {
            System.out.println(next.getMessage());
            System.out.println("Error Code: " + next.getErrorCode());
            System.out.println("SQL State: " + next.getSQLState());
            next = next.getNextException();
        }
    }
}