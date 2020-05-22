FileInputStream fis = new FileInputStream("src/com/homeo/reports/report1.jrxml");
    BufferedInputStream bis = new BufferedInputStream(fis);
    Map map = new HashMap();
    map.put("fuId", fuRprtId);
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OPD", "root", "");

    JasperReport jasperReport = (JasperReport) JasperCompileManager.compileReport(bis);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

    JasperViewer.viewReport(jasperPrint, false);