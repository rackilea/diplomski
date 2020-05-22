JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
                String fileName = "informeDemo.pptx";
                JRPptxExporter exporter = new JRPptxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);
                ByteOutputStream bos=new ByteOutputStream();  // note bos will contain jasperPrint as byte data
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,bos);
                exporter.exportReport();

                response.setContentType("application/vnd.openxmlformats-officedocument.presentationml.presentation"); //Tipo de fichero.
                response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\""); //Configurar cabecera http
                response.setCharacterEncoding("UTF-8");
                response.getOutputStream().write(bos.getBytes()); //note bos is written to response's output stream.
                bos.flush();
                bos.close();
                response.flushBuffer();