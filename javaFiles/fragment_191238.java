StringWriter writer = new StringWriter();
CSVPrinter  csvSkills = new ExcelCsvPrinter(writer);
for (String s:  request.getParameterValues("chkSkills")){
    csvSkills.write(s);
}
return writer.toString();