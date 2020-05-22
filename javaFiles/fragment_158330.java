//Return status from step listener
      @Override
public ExitStatus afterStep(StepExecution stepExecution) {
            if(condition1)
            return new ExitStatus("CUSTOM_STATUS");     
            if(condition2)
            return new ExitStatus("CUSTOM_STATUS_XYZ");     
            if(condition3)
            return new ExitStatus.COMPLETED
}


@Bean
    public Job myJob(JobBuilderFactory jobs) throws Exception {
        return jobs.get("myJob")
                .start(Step1())
                .next(Step2()).on("CUSTOM_STATUS").to(step3())
                .next(Step2()).on("CUSTOM_STATUS_XYZ").to(step4())
                .next(Step2())).on("COMPLETED").to(step4())             
                .build()
                .listener(listener)
                .preventRestart()
                .build();

    }