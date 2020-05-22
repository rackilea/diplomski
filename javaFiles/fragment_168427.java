// ...

StringWriter writer = new StringWriter();
CsvBuilder.writeLine(writer, headers);
CsvBuilder.writeLine(writer, values);
writer.flush();

response.setContentType("text/csv");
response.setHeader("Content-Disposition", "attachment; filename=test.csv");

Scanner scanner = new Scanner(new StringReader(writer.toString()))
while (scanner.hasNext()) {
   response.getWriter().write(scanner.next() + "\n");
}

// ...