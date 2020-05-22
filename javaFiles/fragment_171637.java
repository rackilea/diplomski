String[] args = { "-arg", "value1", "-arg", "value2" };
CommandLineParser parser = new GnuParser();
Options options = new Options();
options.addOption("arg", true, "Argument");
CommandLine line = parser.parse( options, args );

String values[] = line.getOptionValues("arg");
System.out.println(Arrays.asList(values));