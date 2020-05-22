public void buildReport() {
    String query = "SELECT * FROM my_table";
    try (Connection connection = DriverManager.getConnection(getConnectionString(), user, password);
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(query)) {

        JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);
        DynamicReport report = new FastReportBuilder().addColumn("Column1", "column_1", String.class.getName(), 120).setTitle("Sample report").build();

        JasperReport jasperReport = DynamicJasperHelper.generateJasperReport(report, new ClassicLayoutManager(), new HashMap());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "./report.pdf");
    } catch (SQLException | JRException | ClassNotFoundException e) {
        log.error("Failed to build report", e);
    }
}