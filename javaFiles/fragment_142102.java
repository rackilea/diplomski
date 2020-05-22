package mypackage;

public class MyClass {

    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;

    /**
     * This method actually performs the business logic.
     */
    public static void doSomething(String arg1, String arg2) throws SQLException {
        // Actually do something...
    }

    /**
     * This method is called from PL/SQL.
     */
    public static int doSomething(String arg1, String arg2, int[] errorCode, String[] errorMessage) {
        try {
            doSomething(arg1, arg2);
            return success();
        } catch (SQLException e) {
            return failure(e, errorCode, errorMessage);
        }
    }

    private static int success() {
        return SUCCESS;
    }

    private static int failure(SQLException e, int[] errorCode, String[] errorMessage) {
        errorCode[0] = e.getErrorCode();
        errorMessage[0] = e.getMessage();
        return FAILURE;
    }

}