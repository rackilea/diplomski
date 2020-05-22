...
if (list != null && list.size() > 0) {
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

                JasperDesign jd = JRXmlLoader.load(reportStream);
                JasperReport jr = JasperCompileManager.compileReport(jd);
...