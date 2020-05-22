DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
Indenter indenter = new Lf2SpacesIndenter();
printer.indentObjectsWith(indenter); // Indent JSON objects
printer.indentArraysWith(indenter);  // Indent JSON arrays

ObjectMapper mapper = new ObjectMapper();
mapper.writer(printer).writeValue(new FileOutputStream(outputFile), node);