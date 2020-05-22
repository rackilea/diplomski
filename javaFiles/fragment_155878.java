page = submit.click();
String htmlContent = page.asXml();
File htmlFile = new File("C:/index.html");
PrintWriter pw = new PrintWriter(htmlFile, true);
pw.print(htmlContent);
pw.close();