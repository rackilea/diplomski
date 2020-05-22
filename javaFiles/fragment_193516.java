net.sf.jasperreports.engine.design.JasperDesign design = JRXmlLoader.load(
                    new LegacyJasperInputStream(new FileInputStream("C:/Users/my-pc/Desktop/letters/report xml/testreport.jrxml"))
                    );
            JasperReport jasperReport = asperCompileManager.compileReport(design);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            System.out.println("INFO: Report is filled and to be exported to pdf now");

            try {
                // export report to pdf
                JasperExportManager.exportReportToPdfFile(print, "C:/Users/my-pc/Desktop/letters/report xml/test.pdf");
                System.out.println("DEBUG: Expported to pdf");
            } catch (Exception e) {

                System.out.println("EXCEPTION: while generating pdf : "+e);
            }