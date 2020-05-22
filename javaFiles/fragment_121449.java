// Create each flow
Flow flow = new FlowBuilder<Flow>("subflow").from(step1).end();

// Create the job
SimpleJobBuilder builder = new JobBuilder("flow").repository(jobRepository).start(step2);

// Create split providing an async task executor so the flows are executed in parallel
builder.split(new SimpleAsyncTaskExecutor()).add(flow).end();

// Build the job and execute it
builder.preventRestart().build().execute(execution);