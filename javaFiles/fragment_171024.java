public static void updateChallan() throws Exception {
    ChallanNumber pd = null;
    int i=0;
    String customerName = "";
    List<ChallanNumber> challanList= new ArrayList<ChallanNumber>();
    Connection con = DB.getConnection();
    Statement stmt = null;
    try {
        String st = "select CHALLAN_NUMBER,CUSTOMER_CODE,CHALLAN_DATE from DELIVERY_CHALLAN_DETAILS order by CHALLAN_NUMBER";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(st);
        while (rs.next()) {
            String stCustName = "select CUSTOMER_NAME from CUSTOMER_DETAILS where CUSTOMER_CODE='" + rs.getString(2) + "'";
            Statement stmtCustName = con.createStatement();
            try {
                ResultSet rsCustName = stmtCustName.executeQuery(stCustName);
                while (rsCustName.next()){
                    customerName = rsCustName.getString(1);
                }
            } finally {
                if (stmtCustName != null) 
                    stmtCustName.close();
            }

            customerName = rsCustName.getString(1);
            //System.out.println(customerName +" "+i);
            pd = new ChallanNumber(rs.getString(1), customerName, rs.getString(3));
            challanList.add(i, pd);
            i++;
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        if (stmt != null) 
            stmt.close();
    }
    render(challanList);
}