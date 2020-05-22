ArrayList<String> command = new ArrayList<>();
command.add("bash");
command.add("-c");
command.add("echo \"$0\" \"$1\"");
command.addAll(argList);

Process p = Runtime.getRuntime().exec(command.toArray(new String[1]));