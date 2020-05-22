List<String> commands = new LinkedList<String>();
commands.add("node");
commands.add("event.js");

ProcessBuilder processBuilder = new ProcessBuilder(commands);
processBuilder.start();