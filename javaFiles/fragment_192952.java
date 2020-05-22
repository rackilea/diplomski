Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDB", "username", "password");
HashMap<String,Object> parmsMap = new HashMap<String,Object>();
parmsMap.put("id", "157");
String sourceFileName = 
                "D://DynamicReports//src//subreport//masterreport.jasper";
JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parmsMap, conn);
JasperViewer.viewReport(jasperPrint, false);
conn.close();