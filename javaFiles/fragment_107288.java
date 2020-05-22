int size = 5;
String strSQL = "insert into multiplication values (?)"; 
/* 
 * I am assuming your table has only one column.
 * If it has more columns, you need to specify the column where you want 
 * to insert the value:
 *     "insert into multiplication (col1) values (?)"
 *
 * The question mark is a place-holder for the value you are about to insert.
 *
 * I am also assuming that you have a Connection object named "conn".
 */
try(PreparedStatement ps = conn.prepareStatement(strSQL)) {
    for(int i = 1; i <= size; i++) {
        for(int j = 1; j <= size; j++) {
            /*
             * You are multiplying integers, so the result is also an integer
             */
            int x = i * j;
            /*
             * Assign the value to the prepared statement
             */
            ps.setInt(1, x);
            ps.execute(); // The statement is executed HERE
        }
    }
} catch(SQLException e) {
    // Exception handling code
}