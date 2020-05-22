private static final String insertTableSQL = "INSERT INTO ITEM_DETAILS ("
        + "    ITEM_ID,"
        + "    SRV_NAME,"
        + "    INS_TYPE,"
        + "    REQ_CONTEXT,"
        + "    STATUS_FLAG,"
        + "    CHL,"
        + "    TRANSACTION_DATE,"
        + "    REQ_DATETIME,"
        + "    FLAG)" + "values(?,?,?,?,?,?,TO_DATE(?,'DD-MON-RR'),TO_DATE(?,'DD-MON-RR'),?)";

public static void save(){
//.........
smtp.setString(7,"24-07-2016");
smtp.setString(8,"02-8-2016");
//.........