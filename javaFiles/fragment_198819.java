ProcessBuilder builder = new ProcessBuilder();
if (isWindows) {
    builder.command("cmd.exe", "/c", "dir");
} else {
    // this is for bash on linux (can be omitted)
    builder.command("sh", "-c", "ls");
}
builder.directory(new File(System.getProperty("user.home")));
// Start the process here
Process process = builder.start();

// Follow the process to get logging if required
StreamGobbler streamGobbler = 
  new StreamGobbler(process.getInputStream(), System.out::println);

//Submit log collection to and executor for proper scheduling and collection of loggs
Executors.newSingleThreadExecutor().submit(streamGobbler);

// Collect exit code
int exitCode = process.waitFor();
// validate if the appliction exited without errors using exit code
assert exitCode == 0;