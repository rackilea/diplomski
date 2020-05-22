import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class SimpleQueryExecutorTasklet implements Tasklet {

    private DataSource dataSource;
    private String sql;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void setSql(String sql) { this.sql = sql; }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
    public JdbcTemplate getJdbcTemplate () {
        return this.jdbcTemplate == null ? new JdbcTemplate(dataSource) : this.jdbcTemplate;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        getJdbcTemplate().execute(this.sql);
        return RepeatStatus.FINISHED;
    }
}