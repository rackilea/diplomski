public void startAutomation() throws IOException { 
        Set<Integer> pidsBefore = getBrowserPIDs(browserType);
        automator.initDriver(browserType); //calls new ChromeDriver() for example
        Set<Integer> pidsAfter = getBrowserPIDs(browserType);
        pidsAfter.removeAll(pidsBefore);

        ProcessGroupExitWatcher watcher = new ProcessGroupExitWatcher(pidsAfter);
        watcher.addProcessExitListener(new ProcessExitListener() {
            @Override
            public void processFinished() {
                if (automator != null) {
                    automator.closeDriver(); //calls driver.quit()
                    automator = null;
                }
            }
        });
        watcher.start();
        //do webdriver stuff
}

private Set<Integer> getBrowserPIDs(String browserType) throws IOException {
    Set<Integer> processIds = new HashSet<Integer>();

    //powershell was convenient, tasklist is probably safer but requires more parsing
    String cmd = "powershell get-process " + browserType + " | foreach { $_.id }";
    Process processes = Runtime.getRuntime().exec(cmd);
    processes.getOutputStream().close(); //otherwise powershell hangs
    BufferedReader input = new BufferedReader(new InputStreamReader(processes.getInputStream()));
    String line;

    while ((line = input.readLine()) != null) {
        processIds.add(Integer.parseInt(line));
    }
    input.close();

    return processIds;
}