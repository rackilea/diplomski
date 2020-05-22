FileResolver resolver = new FileResolver() {
@Override
public File resolveFile(String filename) {
    return new File("/some/path");
}
};


InputStream jasperfile = getClass().getClassLoader().getResourceAsStream("file.jasper");

LocalJasperReportsContext ctx = new LocalJasperReportsContext(DefaultJasperReportsContext.getInstance());
ctx.setClassLoader(getClass().getClassLoader());
ctx.setFileResolver(resolver);
JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperfile);

JasperFillManager fillmgr = JasperFillManager.getInstance(ctx);
JasperExportManager exmgr = JasperExportManager.getInstance(ctx);

JasperPrint jasperPrint = fillmgr.fill(jasperReport, parameters, beanColDataSource);
ByteArrayOutputStream pdfBytes = new ByteArrayOutputStream();
exmgr.exportToPdfStream(jasperPrint, pdfBytes);