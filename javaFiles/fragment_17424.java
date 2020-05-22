class Workspace {
    private List<Job> jobs;
    public List<Job> getJobs() {
        return jobs;
    }
}
class Job {
    private String currency;
    private int amount;
    public String getCurrency() {
        return currency;
    }
    public int getAmount() {
        return amount;
    }
}