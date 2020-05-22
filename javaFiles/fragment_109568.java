/**
* @return a new JobParameters object containing only a parameter for the
* current timestamp, to ensure that the job instance will be unique.
*/
public JobParameters getUniqueJobParameters() {Map<String, JobParameter> 
parameters = new HashMap<String, JobParameter>();
parameters.put("random", new JobParameter((long) (Math.random() * JOB_PARAMETER_MAXIMUM)));
return new JobParameters(parameters);
}