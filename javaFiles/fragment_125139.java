String sql2 = "select entryDt,Student_Name,Class_Div_Name,ReceiptNo from test where ReceiptNo = ?";
PreparedStatement stat = con.prepareStatement(sql2);

try {
    while (obt.hasNext()) {
        try {
            Object itrvalue = obt.next();
            System.out.println("Receipt No --" + itrvalue);
            stat.setObject(1, itrvalue);
            rs = stat.executeQuery();
            rs.next();
            Date datevalue = rs.getDate(1);
            String name = rs.getString(2);
            String CDN = rs.getString(3);
            String RNO = rs.getString(4);
            System.out.println("Date is ---" + datevalue);
            System.out.println("Student Name ---" + name);
            System.out.println("Coloumn Div No ---" + CDN);
            System.out.println("Receipt No ---" + RNO);
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
} finally {
    if (stat != null) {
        stat.close();
    }
}