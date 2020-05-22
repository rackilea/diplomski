String filePath = "File path where you want to keep your report";
String reportFileName = "myReport.htm";

JUnitCore junit = new JUnitCore();
junit.addListener(new MyJunitListener());
Result result = junit.run(AllEJBJunitTests.class);
StringBuffer myContent = getResultContent(result, size);//Size represents number of AllEJBJunitTests class, suppose if you have 5 EJB classes then size is 5.
writeReportFile(filePath + "/" + reportFileName, myContent);