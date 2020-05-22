try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OPD", "root", "")) {
    InputStream inputStream = getClass().getResourceAsStream("/com/homeo/reports/report1.jasper");

    JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, con);
    JasperViewer.viewReport(jasperPrint, false);
    con.close();  
}
  } catch (SQLException | ClassNotFoundException | JRException ex) {
        Logger.getLogger(FollowUpController.class
                .getName()).log(Level.SEVERE, null, ex);
}