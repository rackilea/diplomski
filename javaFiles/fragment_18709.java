@Bean
@ServiceActivator(inputChannel = "sftpChannel")
public MessageHandler handler() {
    final FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
    handler.setFileExistsMode(FileExistsMode.REPLACE);
    handler.setExpectReply(true);
    handler.setOutputChannelName("parse-csv-channel");
    return handler;
}

@ServiceActivator(inputChannel = "parse-csv-channel", outputChannel = "job-channel")
public JobLaunchRequest adapt(final File file) throws Exception {
    final JobParameters jobParameters = new JobParametersBuilder().addString(
            "input.file", file.getAbsolutePath()).toJobParameters();
    return new JobLaunchRequest(batchConfiguration.job(), jobParameters);
}

@Bean
@ServiceActivator(inputChannel = "job-channel")
public JobLaunchingGateway jobHandler() {
    JobLaunchingGateway jobLaunchingGateway = new JobLaunchingGateway(jobLauncher);
    jobLaunchingGateway.setOutputChannelName("finish");
    return jobLaunchingGateway;
}