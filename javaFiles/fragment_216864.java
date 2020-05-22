class InsertSQL3 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/iac_enrollment_system";
    static final String USER = "root";
    static final String PASS = "***";

    private int noOfRecords;
    private String[] saCourseCode;
    private String[] saCourseDesc;
    private String[] saCourseChair;

    private Connection conn = null;
    private Statement stmt = null;

    private Scanner scn;

    public InsertSQL3() {
        scn = new Scanner(System.in);
    }

    private void initConnection() {
       ...
    }

    private void getInput() {

        // Get number of records
        System.out.print("How many records do you want to insert? ");
        noOfRecords = Integer.parseInt(scn.nextLine());

        saCourseCode = new String[noOfRecords];
        saCourseDesc = new String[noOfRecords];
        saCourseChair = new String[noOfRecords];

        ...
    }

    private void executeQuery() {
         ...
    }



    public static void main(String[] args) {
        InsertSQL3 insertApp = new InsertSQL3();
        insertApp.initConnection();
        insertApp.getInput();
        insertApp.executeQuery();

        System.out.println("Thank you for your patronage!");
    }
}