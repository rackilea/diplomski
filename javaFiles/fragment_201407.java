List<Process> processes = new ArrayList<>();

for (String command: commands) {
    Process process = Runtime.getRuntime().exec(command);

    (new BackgroundReaderThread(process.getInputStream())).start();
    (new BackgroundReaderThread(process.getErrorStream())).start();

    processes.add(process);
}

for (Process process: processes) {
    process.waitFor();
}