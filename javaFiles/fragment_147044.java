import java.util.Arrays;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class MyJob {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public JdbcCursorItemReader<Person> itemReader() {
        return new JdbcCursorItemReaderBuilder<Person>()
                .name("personItemReader")
                .dataSource(dataSource())
                .sql("select id, name from person where processed = false")
                .beanRowMapper(Person.class)
                .saveState(false) // process indicator pattern, no need to save state (see https://docs.spring.io/spring-batch/4.1.x/reference/html/readersAndWriters.html#process-indicator)
                .build();
    }

    @Bean
    public ItemProcessor<Person, Person> itemProcessor() {
        return item -> new Person(item.getId(), item.getName().toUpperCase());
    }

    @Bean
    public CompositeItemWriter<Person> itemWriter() {
        return new CompositeItemWriterBuilder<Person>()
                .delegates(Arrays.asList(peopleItemWriter(), personItemUpdater()))
                .ignoreItemStream(true)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> peopleItemWriter() {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource())
                .beanMapped()
                .sql("insert into people (name) values (:name)")
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> personItemUpdater() {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource())
                .beanMapped()
                .sql("update person set processed = true where id = :id")
                .build();
    }

    @Bean
    public Step step() {
        return steps.get("step")
                .<Person, Person>chunk(1)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job() {
        return jobs.get("job")
                .start(step())
                .build();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        jdbcTemplate.execute("CREATE TABLE person (id int IDENTITY PRIMARY KEY, name VARCHAR(10), processed boolean);");
        jdbcTemplate.execute("CREATE TABLE people (id int IDENTITY PRIMARY KEY, name VARCHAR(10));");
        jdbcTemplate.execute("insert into person (id, name, processed) values (1, 'foo', false);");
        jdbcTemplate.execute("insert into person (id, name, processed) values (2, 'bar', false);");

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());

        Integer nbInsertedFoos = jdbcTemplate.queryForObject("select count(id) from people where name = 'FOO'", Integer.class);
        Integer nbInsertedBars = jdbcTemplate.queryForObject("select count(id) from people where name = 'BAR'", Integer.class);
        System.out.println("nbInsertedFoos in people table = " + nbInsertedFoos);
        System.out.println("nbInsertedBars in people table = " + nbInsertedBars);
        Integer nbUpdatedPersons = jdbcTemplate.queryForObject("select count(*) from person where processed = true", Integer.class);
        System.out.println("nbUpdatedPersons in person table = " + nbUpdatedPersons);
    }

    public static class Person {

        private int id;

        private String name;

        public Person() {
        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}