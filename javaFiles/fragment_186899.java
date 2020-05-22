List<String> arguments = new LinkedList<String>();
arguments.add("build");
arguments.add(projectName);

arguments.add("-p");
arguments.add("options.properties=system.props");
arguments.add("-p");
arguments.add("anotherOption=optionValue");

arguments.add("-s");
arguments.add("-v");
CLI cli  = new CLI(new URL(url));
cli.upgrade();
int exit_code = cli.execute(arguments);