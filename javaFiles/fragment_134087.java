XStream xStream = new XStream();
xStream.registerConverter(new ReportConverter());
xStream.alias("patient", Patient.class);
xStream.alias("report", Report.class);
String xml = "<patient><name>Mr. Sick</name><report><paragraph>" +
        "some text here<bold>Conclusion</bold>text...</paragraph>" +
        "<sdf>hello world</sdf></report></patient>";
Patient patient = (Patient)xStream.fromXML(xml);
System.out.println("patient.name: " + patient.name);
System.out.println("patient.report: " + patient.report.report);