@Bean
public FileMessageToJobRequest fileMessageToJobRequest(Job job) {
     FileMessageToJobRequest fileMessageToJobRequest = new FileMessageToJobRequest();
     fileMessageToJobRequest.setJob(job);
     fileMessageToJobRequest.setfileParameterName("file");
     return fileMessageToJobRequest;
}
...

@Bean
public IntegrationFlow flowToBatch(FileMessageToJobRequest fileMessageToJobRequest) {

      return IntegrationFlows
            .from(Files.inboundAdapter(directory)
                    .preventDuplicates()
                    .patternFilter("*.txt")))
            .transform(fileMessageToJobRequest)
            .handle(jobLaunchingGw())                       
                    .get();

}