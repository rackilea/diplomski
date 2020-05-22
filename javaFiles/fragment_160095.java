Optional<ProcessHandle> optional = ProcessHandle.allProcesses().filter(process -> {
    Optional<String> command = process.info().command();
    return command.isPresent() && command.get().equals("Chromedriver.exe");
}).findFirst();
if (optional.isPresent()) {
    ProcessHandle processHandle = optional.get();
    System.out.println("Killing process " + processHandle.pid());
    processHandle.destroy();
    try {
        System.out.println("Waiting for process " + processHandle.pid() + " to exit...");
        processHandle.onExit().get();
        System.out.println("Done !");
    } catch (InterruptedException|ExecutionException e) {
        e.printStackTrace();
    }
}