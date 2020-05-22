public class Job {
    public int time = 500; // Should n't this be a long?
    public String jobName;
    public boolean processed = false;

    public Job(int time, String jobName) {
        this.time = time;
        this.jobName = jobName;
    }

    public boolean isProcessed() {
        return processed;
    }
}