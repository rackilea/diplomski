String exe = "absolute path to executable file";
ProcessBuilder builder = new ProcessBuilder();
builder.command().add("bash");
builder.command().add("-c");
builder.command().add("stdbuf -o0 " + exe);
builder.redirectErrorStream(true);
Process process = builder.start();