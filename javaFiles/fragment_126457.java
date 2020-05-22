OutputStream printOut = new FileOutputStream(new File("C:/Users/bla/Desktop/test/jasperprint.jasperprint"));
    JasperFillManager.fillReportToStream(jasperReport, printOut, reportparameter.getAll(), dataSource);
    printOut.close();

    OutputStream output = new FileOutputStream(new File("C:/Users/bla/test/JasperReport.pdf"));
    JasperExportManager.exportReportToPdfStream(new FileInputStream(new File("C:/Users/bla/Desktop/test/jasperprint.jasperprint")), output);
    output.close();