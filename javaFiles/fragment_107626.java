import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class TestEnumTypeHandler extends BaseTypeHandler<TestEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TestEnum parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getDisplay());
    }

    @Override
    public TestEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return TestEnum.fromDisplay(rs.getString(columnName));
    }

    @Override
    public TestEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return TestEnum.fromDisplay(rs.getString(columnIndex));
    }

    @Override
    public TestEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return TestEnum.fromDisplay(cs.getString(columnIndex));
    }
}