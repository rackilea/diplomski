import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ABCRowMapper implements RowMapper<ABC> {

    @Override
    public ABC mapRow(ResultSet rs, int rowNum) throws SQLException {
        ABC abc = new ABC();
        abc.setDateTime(rs.getLong("DT"));
        abc.setStmt(rs.getBoolean("SP"));

        return abc;
    }

}