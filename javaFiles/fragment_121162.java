@Autowired
JobLauncher jobLauncher;

public void startExecution() {
    jobLauncher.run(job, jobParemeters);
}