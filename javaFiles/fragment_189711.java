public static void main(String[] args) {
    List<Job> jobList  = generateDummyJobs();
    Collections.sort(jobList);
    printJobs(jobList);
    calculateWaitTime(jobList);       
}

private static List<Job> generateDummyJobs() {
    List<Job> jobList = new ArrayList<Job>();
    Job job1 = new Job("P1", 3, 5);
    Job job2 = new Job("P2", 1, 6);
    Job job3 = new Job("P3", 5, 2);
    jobList.add(job1);
    jobList.add(job2);
    jobList.add(job3);
    return jobList;       
}

private static void printJobs(List<Job> jobList) {
    for(Job job :jobList) {
        System.out.println("[" + job.getId() + ", " + job.getArrivalTime() + ", " + job.getBurstTime() + "]" );    
    }
}

private static void calculateWaitTime(List<Job> jobList) {
    int serviceTime = 1;
    for(Job job :jobList) {
        System.out.println(job.getId() + ": " + (serviceTime - job.getArrivalTime()));
        serviceTime += job.getBurstTime();
    }
}