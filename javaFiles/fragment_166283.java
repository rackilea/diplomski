Job job1 = new Job(conf, "job 1");
//your job setup here
//...
job1.submit();
job1.waitForCompletion(true);

int job2Reducers = ... //compute based on job1 results here

Job job2 = new Job(conf, "job 2");
job2.setNumReduceTasks(job2Reducers);
//your job2 setup here
//...
job2.submit();
job2.waitForCompletion(true);