Map hm = new HashMap();
JasperPrint print = null;
JRSwapFileVirtualizer virtualizer = null;
JRSwapFile swapFile = new JRSwapFile("D://", 2048, 1024);
virtualizer = new JRSwapFileVirtualizer(2,swapFile,true);
JRVirtualizationHelper.setThreadVirtualizer(virtualizer);
hm.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
if (type.toUpperCase().equalsIgnoreCase(FileTypes.XLS.name()))
{
    hm.put(JRParameter.IS_IGNORE_PAGINATION, new Boolean(false));
}
JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
                    list);
JRExporter exporter = null;
            if (type.toUpperCase().equalsIgnoreCase(FileTypes.PDF.name())) {
                exporter = new JRPdfExporter();

            } else if (type.toUpperCase().equalsIgnoreCase(FileTypes.XLS.name())) {
                exporter = new JRXlsExporter();
            }

            if(exporter != null)
            {
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                        outFileName);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.exportReport();
            }