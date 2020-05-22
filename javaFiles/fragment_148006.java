List<RunningJob> runningJobs = new ArrayList<RunningJob>();
for (String jobSpec: jobSpecs) {
    // Configure, for example, a params map that gets passed into the MR class's constructor
    ToolRunner.run(new Configuration(), new MapReduceClass(params, runningJobs), null);
}

for (RunningJob rj: runningJobs) {
    System.err.println("Waiting on job "+rj.getID());
    rj.waitForCompletion();
}