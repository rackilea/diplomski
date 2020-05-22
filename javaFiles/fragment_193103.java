private void dostuff() throws JRException, IOException {
    Map<String, Object> params = new HashMap<String, Object>();
    File f = new File("C:\\report1.pdf");
    InputStream fis = new FileInputStream(f);
    JasperReport jrsub = JasperCompileManager.compileReport(fis);

    List<OficioSipoData> l = new ArrayList<OficioSipoData>();
    for (int i = 0; i < 5; i++) {
        addDummyOSD(l, i);
    }

    byte[] bytes = JasperRunManager.runReportToPdf(jrsub, params, 
            new JRBeanArrayDataSource(l.toArray()));
    FileOutputStream fos = new FileOutputStream(new File(""C:\\report1.pdf""));
    fos.write(bytes);
    fos.close();
    System.out.println("fine");
}