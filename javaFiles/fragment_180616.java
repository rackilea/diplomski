final static public String APP_ID = "MY_APP";
private static DBConnection conn = new DBConnection(APP_ID);

public ProcessService() {
    System.out.println("-----------------------CONSTRUCTOR CALLED --------------------------");
    // conn is now a static variable so the connection is created only once
    System.out.println("-----------------------CONSTRUCTOR CALLED-2 --------------------------");
}