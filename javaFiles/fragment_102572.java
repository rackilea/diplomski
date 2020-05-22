public class DeleteTableTasklet implements Tasklet {

@Override
public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    new JdbcTemplate(this.dataSource).executeQuery(this.sql)
    return RepeatStatus.FINISHED;
}
}