List<String> vsArrays = new ArrayList<String>();
vsArrays.add("/bin/sh");
vsArrays.add("-c");
vsArrays.add("echo '123' > ~/1.rad; echo '123' > ~/2.rad; echo '123' > ~/3.rad");

ProcessBuilder proc = new ProcessBuilder(vsArrays);
Process start = proc.start();
start.waitFor();