package com.example.logintracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles all persisting of data to database or other storage mechanism. Called from other code handling business logic.
 *
 * This source code available via the Free Public License 1.0.0. http://opensource.org/licenses/FPL-1.0.0
 *
 * @author Basil Bourque
 *
 */
public class Persister {

    public void saveLoginAttempt ( LoginAttempt loginAttempt ) {
        // Get database connection.
        // Make prepared statement.
        // Transfer pieces of data from LoginAttempt into PreparedStatement.
        // Execute database transaction.

        StringBuilder sql = new StringBuilder ();
        sql.append ( "INSERT INTO login_attempt_ ( username_ , when_attempted_ , success_ , uuid_ ) " + " \n" );
        sql.append ( "VALUES ( ? , ? , ? , ? )" + " \n" );
        sql.append ( ";" + " \n" );

        try ( Connection conn = this.fetchConnection (); ) {
//            System.out.println ( "conn: " + conn );

            try ( PreparedStatement ps = conn.prepareStatement ( sql.toString () ); ) {
                ps.setString ( 1 , loginAttempt.getUserName () );
                java.sql.Timestamp ts = java.sql.Timestamp.from ( loginAttempt.getWhenAttempted () );  // Converting from java.time.Instant to java.sql.Timestamp.
                ps.setTimestamp ( 2 , ts );
                ps.setBoolean ( 3 , loginAttempt.getSuccessful () );
                ps.setObject ( 4 , loginAttempt.getUuid () );
                ps.executeUpdate ();

            } catch ( SQLException ex ) {
                System.err.println ( "SQLException: " + ex.getMessage () );
                // TODO: Handle exception.
            }
        } catch ( SQLException ex ) {
            System.err.println ( "SQLException on this.fetchConnection: " + ex.getMessage () );
            // TODO: Handle exception.
        }

    }

    public LoginAttempt fetchMostRecentLoginAttempt () {
        // Get database connection.
        // Make prepared statement.
        // Execute query.
        // Transfer pieces of data from ResultSet to new LoginAttempt object.
        // Return object (or null if failure occurred).

        StringBuilder sql = new StringBuilder ();
        sql.append ( "SELECT * " + " \n" );
        sql.append ( "FROM login_attempt_" + " \n" );
        sql.append ( "ORDER BY when_attempted_ DESC" + " \n" );
        sql.append ( "LIMIT 1" + " \n" );
        sql.append ( ";" + " \n" );

        LoginAttempt loginAttempt = null;
        try ( Connection conn = this.fetchConnection (); ) {
//            System.out.println ( "conn: " + conn );

            try ( Statement stmt = conn.createStatement (); ) {
                ResultSet rs = stmt.executeQuery ( sql.toString () );
                int count = 0;
                while ( rs.next () ) {
                    count ++;
                    String userName = rs.getString ( "username_" );
                    java.sql.Timestamp whenWritten = rs.getTimestamp ( "when_attempted_" );
                    Boolean success = rs.getBoolean ( "success_" );
                    UUID uuid = ( UUID ) rs.getObject ( "uuid_" );
                    loginAttempt = new LoginAttempt ( userName , whenWritten.toInstant () , success , uuid );  // Converting from java.sql.Timestamp to java.time.Instant.
                }
                if ( count > 1 ) {
                    // TODO: Handle problem where more than one row returned.
                }

            } catch ( SQLException ex ) {
                System.err.println ( "SQLException: " + ex.getMessage () );
                // TODO: Handle exception.
            }
        } catch ( SQLException ex ) {
            System.err.println ( "SQLException on this.fetchConnection: " + ex.getMessage () );
            // TODO: Handle exception.
        }
        return loginAttempt;
    }

    private Connection fetchConnection () throws SQLException {
        Connection conn = null;

        try {
            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            // TODO: Handle exception.
            System.out.println ( "Database failure: " + e );
            return null;
        }

        // Specify a database named 'LoginTracker.mv.db' in the Unix user’s home folder.
        String dbFolderPath = "~/";
        String dbName = "LoginTracker";
        String dbUrl = "jdbc:h2:" + dbFolderPath + dbName;
        String dbUserName = "h2";
        String dbPassword = "pw";

        try {
            // If database does not yet exist, it is automatically created.
            conn = DriverManager.getConnection ( dbUrl , dbUserName , dbPassword );
        } catch ( SQLException ex ) {
            System.out.println ( "SQLException on DriverManager.getConnection: " + ex.getMessage () );
            // TODO: Handle exception when no Connection is made.
        }

        if ( null == conn ) {
            System.out.println ( "Database error. No Connection." );
            // TODO: Handle exception when no Connection is made.
        } else {
            // ELSE got database connection. Normal.
            this.updateDatabaseStructureIfNeedBe ( conn );
        }

        return conn;
    }

    private void updateDatabaseStructureIfNeedBe ( Connection conn ) {
        // Update database structure if needed.

        // 'login_attempt_' Table.
        StringBuilder sql = new StringBuilder ();
        sql.append ( "CREATE TABlE IF NOT EXISTS login_attempt_" + " \n" );
        sql.append ( "(" + " \n" );
        sql.append ( "uuid_ UUID DEFAULT RANDOM_UUID() PRIMARY KEY," + " \n" );  // Primary key, UUID type.
        sql.append ( "when_written_ TIMESTAMP DEFAULT NOW() NOT NULL," + " \n" );  // Record when this record was written to database. Apparently H2 only provides txn start time, not current time.
        sql.append ( "username_ VARCHAR_IGNORECASE(255) NOT NULL," + " \n" );  // User’s name. Case-insensitive.
        sql.append ( "when_attempted_ TIMESTAMP NOT NULL," + " \n" );  // When this login attempt was made.
        sql.append ( "success_ BOOLEAN NOT NULL" + " \n" );  // Did this login attempt succeed or fail?
        sql.append ( ")" + " \n" );
        sql.append ( ";" + " \n" );

        try ( Statement stmt = conn.createStatement () ) {
            stmt.executeUpdate ( sql.toString () );
            stmt.close ();

        } catch ( SQLException ex ) {
            System.err.println ( "SQLException: " + ex.getMessage () );
            // TODO: Handle exception.
        }

    }

}