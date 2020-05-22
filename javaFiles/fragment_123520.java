in.useDelimiter("\n");
//Create an array of type job to keep track of our number of jobs.
Job[] jobs = new Job[m];
for(int i = 0; i < m; i++){
    jobs[i] = getJob(in);
    System.out.println(jobs[i]);
}