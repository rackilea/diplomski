package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo
{
    private static final String SELECT_SAVED_DATA = "select * from saveData";

    private Connection connection;

    public JdbcDemo(Connection connection)
    {
        this.connection = connection;
    }

    public List<String> getSavedData() throws SQLException
    {
        List<String> savedData = new ArrayList<String>();

        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = this.connection.createStatement();
            rs = stmt.executeQuery(SELECT_SAVED_DATA);
            while (rs.next())
            {
                savedData.add(rs.getString(1)); // modify this as needed
            }
        }
        finally
        {
            DatabaseUtils.close(rs);
            DatabaseUtils.close(stmt);
        }

        return savedData;
    }
}