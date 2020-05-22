OracleWebRowSet rs = new OracleWebRowSet();
System.setProperty("javax.xml.parsers.SAXParserFactory","oracle.xml.jaxp.JXSAXParserFactory");
FileReader fReader = new FileReader("xmlfile.xml");
rs.readXml(fReader);
rs.setReader(new OracleCachedRowSetReader());
rs.setWriter(new OracleCachedRowSetWriter());
rs.acceptChanges();
rs.close();