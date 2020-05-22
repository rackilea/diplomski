public class MyTaskManager extends TaskManager<String, Process, Integer> {

    // private fields ....

    public String init() {
        return "echo 'Hello'";
    }

    public Process start() {
        Process p = new Process(this.command);
        p.start();
        return p;
    }

    public Integer shutDown() {
        int exitCode = this.process.stop();
        return exitCode;
    }

    public void analyzeAfterInit(String initResult) {
        this.command = initResult;
        verifyCommand(initResult);
    }

    public void analyzeAfterStart(Process startResult) {
        this.process = startResult;
    }
}