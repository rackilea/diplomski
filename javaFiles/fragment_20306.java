import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class SimpleQueryExecutorTaskletTest {

    @InjectMocks
    SimpleQueryExecutorTasklet simpleQueryExecutorTasklet;

    @Mock
    StepContribution stepContribution;

    @Mock
    ChunkContext chunkContext;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    DataSource dataSource;

    String sql="select * from abc;";

    @Before
    public void setUp() throws Exception {
        simpleQueryExecutorTasklet.setDataSource(dataSource);
        simpleQueryExecutorTasklet.setSql(sql);
        //PowerMockito.whenNew(JdbcTemplate.class).withAnyArguments().thenReturn(jdbcTemplate);
    }

    @Test
    public void testExecute() throws Exception{
        simpleQueryExecutorTasklet.setJdbcTemplate(jdbcTemplate);
        RepeatStatus repeatStatus = simpleQueryExecutorTasklet.execute(stepContribution,chunkContext);
        assertNotNull(repeatStatus);
        assertSame("FINISHED", repeatStatus.toString());
    }
    @Test(expected = NullPointerException.class)
    public void testExecute_Exception() throws Exception{
        simpleQueryExecutorTasklet.setJdbcTemplate(null);
        simpleQueryExecutorTasklet.execute(stepContribution,chunkContext);
    }
}