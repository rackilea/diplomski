public class Go {
    public static void main(String args[]) {
        while(true) {
            try {
                String userID = getUserId();
                Connection con = getConnection();
                processUserId(connection, userId);
                con.close();
            catch(Exception e) {
                logException(e);
            }
        }
    }
}