import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import java.util.Map;
import java.util.HashMap;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SqlConnectionUtil.class, RccSqlParameterMap.class })
public class TestQueryRunner {

    @Test
    public void testGetResultSetFromSql() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getString(eq("foo"))).thenReturn("This is mocked value");

        PreparedStatement stmt = mock(PreparedStatement.class);
        when(stmt.getResultSet()).thenReturn(rs);
        when(stmt.execute()).thenReturn(true);

        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString(), anyInt(), anyInt()))
                .thenReturn(stmt);

        PowerMockito.mockStatic(SqlConnectionUtil.class);
        PowerMockito.when(SqlConnectionUtil.getDbConnection(anyString(), anyString()))
                .thenReturn(connection);

        Map<String, String> sqlParams = new HashMap<>();
        sqlParams.put("param1", "value1");
        RccSqlParameterMap paramMap = mock(RccSqlParameterMap.class);
        when(paramMap.getSqlParameters()).thenReturn(sqlParams);

        PowerMockito.mockStatic(RccSqlParameterMap.class);
        PowerMockito.when(RccSqlParameterMap.getParameterMap()).thenReturn(paramMap);       

        ResultSet actual = QueryRunner.getResultSetFromSql("SELECT ...",
                "tenant", "product");
        assertEquals(rs, actual);
        assertEquals("This is mocked value", actual.getString("foo"));
    }

}