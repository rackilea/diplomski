String file = /pathToMainReport/name.jrxml;
            String subreport1 = /pathToSubReport/name1.jasper;
            String subreport2 = /pathToSubReport/name2.jasper;      

            JasperReport jreport = JasperCompileManager.compileReport(file);


            Map<String, Object> map = new HashMap<String, Object>();

            map.put("SUBREPORT_DIR1", subreport1);
            map.put("SUBREPORT_DIR2", subreport2);

            JasperPrint jprint = JasperFillManager.fillReport(jreport, map, connection);