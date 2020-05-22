Reporting reporting = new Reporting();
reporting.setFileName("home.pdf");

ReportingFile reportingFile = new ReportingFile();
// It will not persisted because of insertable=false, updatable=false
reportingFile.setFileName("home.pdf");
reportingFile.setXmlContent(someClobObject);

session.save(reporting); // It works