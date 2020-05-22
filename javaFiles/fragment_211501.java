import java.sql.*;
import oracle.jdbc.*;
import oracle.sql.*;

public class ArrayTest {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe", "user", "pass");

        CallableStatement stmt = conn.prepareCall("BEGIN p_array_test(?); END;");

        // The first parameter here should be the name of the array type.
        // It's been capitalised here since I created it without using
        // double quotes.
        ArrayDescriptor arrDesc =
            ArrayDescriptor.createDescriptor("T_VARCHAR2_ARRAY", conn);

        String[] data = { "one", "two", "three" };
        Array array = new ARRAY(arrDesc, conn, data);
        stmt.setArray(1, array);
        stmt.execute();

        conn.commit();
        conn.close();
    }
}