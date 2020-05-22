import java.sql.ResultSet;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ABCRowMapperTest {

    @Test
    public void testABCRowMapper() throws Exception {
        // given
        ABCRowMapper rowMapper = new ABCRowMapper();
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getLong("DT")).thenReturn(1L);
        Mockito.when(resultSet.getBoolean("SP")).thenReturn(true);

        // when
        ABC abc = rowMapper.mapRow(resultSet, 1);

        // then
        Assert.assertNotNull(abc);
        Assert.assertEquals(abc.getDateTime(), 1L);
        Assert.assertTrue(abc.getStmt());
    }
}