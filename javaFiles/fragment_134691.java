new PriorityQueue<JobType>(10, new Comparator<JobType>() {

    @Override
    public int compare(JobType o1, JobType o2) {
             return Double.compare(o1.sTime,o2.sTime); 
    }
    });