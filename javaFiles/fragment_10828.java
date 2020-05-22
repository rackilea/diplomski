import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step step1() {
        return steps.get("step1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("hello");
                    throw new Exception("Boom!");
                })
                .build();
    }

    @Bean
    public Step step2() {
        return steps.get("step2")
                .tasklet((contribution, chunkContext) -> {
                    JobExecution jobExecution = chunkContext.getStepContext().getStepExecution().getJobExecution();
                    StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next(); // TODO properly get the stepExecution of the previous step
                    List<Throwable> failureExceptions = stepExecution.getFailureExceptions();
                    if (!failureExceptions.isEmpty()) {
                        Throwable throwable = failureExceptions.get(0);
                        System.out.println("Looks like step1 has thrown an exception: " + throwable.getMessage());
                    }
                    System.out.println("world");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Job job() {
        return jobs.get("job")
                    .flow(step1())
                    .on("*").to(step2())
                    .build()
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}