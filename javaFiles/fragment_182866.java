public static void testBuildPdf() {
    try {
        Map<String, Object> params = new HashMap<String, Object>();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, getDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static JRDataSource getDataSource() {
    Collection<BeanWithList> coll = new ArrayList<BeanWithList>();
    coll.add(new BeanWithList(Arrays.asList("London", "Paris"), 1));
    coll.add(new BeanWithList(Arrays.asList("London", "Madrid", "Moscow"), 2));
    coll.add(new BeanWithList(Arrays.asList("Rome"), 3));

    return new JRBeanCollectionDataSource(coll);
}