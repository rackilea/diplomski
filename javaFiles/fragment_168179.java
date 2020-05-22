Statement stmt = null;
Connection connect = null;
List<SPACE_CreateLicenseModel> allData = new ArrayList<SPACE_CreateLicenseModel>();
try {
    connect = SPACE_DBController.SPACE_getConnection();
    ....
        while (result.next()) {    
           SPACE_CreateLicenseModel view = new SPACE_CreateLicenseModel();