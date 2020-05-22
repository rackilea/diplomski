SystemInfo si = new SystemInfo();
OperatingSystem os = si.getOperatingSystem();
OSProcess[] procs = os.getProcesses(0, null);

for (OSProcess p : procs) {
    if (p.getName().contains("Chrome")) {
        // do stuff with p
    }
}