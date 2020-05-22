import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableBatchProcessing
public class MyJob {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

    @Component
    public static class MyJobFactoryBean implements FactoryBean<Job> {

        private final JobBuilderFactory jobs;

        private final StepBuilderFactory steps;

        public MyJobFactoryBean(JobBuilderFactory jobs, StepBuilderFactory steps) {
           this.jobs = jobs;
           this.steps = steps;
        }

        @Override
        public Job getObject() {
            Step step = steps.get("step")
                    .tasklet((contribution, chunkContext) -> {
                        System.out.println("hello world");
                        return RepeatStatus.FINISHED;
                    })
                    .build();

            return jobs.get("job")
                    .start(step)
                    .build();
        }

        @Override
        public Class<?> getObjectType() {
            return Job.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }
    }

}