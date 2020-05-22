String date1 = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
    String date2 = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
    try {

        Connection conn = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }

    String url = "jdbc:sqlserver://localhost:1433;databaseName=bradb";
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, "sa", "oraclee");
    } catch (SQLException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }

    JasperDesign jd = null;
    try {
        jd = JRXmlLoader.load("E:\\bra\\src\\facilitiReport2.jrxml");
    } catch (JRException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }
    String sql = "SELECT * FROM facilitiTable WHERE deptDate BETWEEN '" + date1 + "' AND '" + date2 + "' ";
    JRDesignQuery newq = new JRDesignQuery();
    newq.setText(sql);

    jd.setQuery(newq);
    JasperReport jr = null;
    try {
        jr = JasperCompileManager.compileReport(jd);

    } catch (JRException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }

    JasperPrint jp = null;
    try {
        jp = JasperFillManager.fillReport(jr, null, conn);
    } catch (JRException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }

    JasperViewer.viewReport(jp);
    try {
        conn.close();

    } catch (SQLException ex) {
        Logger.getLogger(facilitiReports.class.getName()).log(Level.SEVERE, null, ex);
    }