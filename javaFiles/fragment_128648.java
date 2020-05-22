package work.basil.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    public String getFirstUserName ( )
    {
        String userName = "QUERY-FAILED";

        String newline = "\n";
        StringBuilder sql = new StringBuilder();
        sql.append( "SELECT name_ from  user_ ; " ).append( newline );
        System.out.println( "sql = " + sql );
        try (
                Connection conn = App.INSTANCE.provideDataSource().getConnection() ;
                Statement statement = conn.createStatement() ;
                ResultSet resultSet = statement.executeQuery( sql.toString() ) ;
        )
        {
            while ( resultSet.next() )
            {
                userName = resultSet.getString( "name_" );
                break; // Go no further. We need only the first row found.
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }

        return userName;
    }

    public void initializeDatabase ( )
    {
        System.out.println( "DEBUG Running `initializeDatabase` of " + this.getClass().getCanonicalName() );
        String newline = "\n";

        // Create table.
        StringBuilder sql = new StringBuilder();
        sql.append( "CREATE TABLE user_ ( " ).append( newline );
        sql.append( "pkey_ IDENTITY NOT NULL PRIMARY KEY , " ).append( newline );  // `identity` = auto-incrementing long integer.
        sql.append( "name_ VARCHAR NOT NULL " ).append( newline );
        sql.append( ") " ).append( newline );
        sql.append( ";" ).append( newline );
        System.out.println( "sql = " + sql );
        try (
                Connection conn = App.INSTANCE.provideDataSource().getConnection() ;
                Statement statement = conn.createStatement() ;
        )
        {
            statement.executeUpdate( sql.toString() );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        System.out.println("DEBUG Finished `CREATE TABLE` statement.");

        // Populate table.
        sql = new StringBuilder();
        sql.append( "INSERT INTO user_ ( name_ ) " ).append( newline );
        sql.append( "VALUES " ).append( newline );
        sql.append( "( 'Alice' ) , " ).append( newline );
        sql.append( "( 'Bob' ) , " ).append( newline );
        sql.append( "( 'Carol' ) " ).append( newline );
        sql.append( ";" ).append( newline );
        System.out.println( "sql = " + sql );
        try (
                Connection conn = App.INSTANCE.provideDataSource().getConnection() ;
                Statement statement = conn.createStatement() ;
        )
        {
            int rowsAffected = statement.executeUpdate( sql.toString() );
            System.out.println( "DEBUG Inserted rows into name_ table: " + rowsAffected );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        System.out.println("DEBUG Finished `INSERT` statement.");
    }
}