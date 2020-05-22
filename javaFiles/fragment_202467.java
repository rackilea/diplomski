import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import oracle.jdbc.OracleConnection;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.support.AbstractSqlTypeValue;

public class SqlBlobArrayValue extends AbstractSqlTypeValue {

    private List<byte[]> values;

    private String defaultTypeName;

    public SqlBlobArrayValue(List<byte[]> values) {
        this.values = values;
    }

    public SqlBlobArrayValue(List<byte[]> values, String defaultTypeName) {
        this.values = values;
        this.defaultTypeName = defaultTypeName;
    }

    protected Object createTypeValue(Connection conn, int sqlType, String typeName)
            throws SQLException {
        if (typeName == null && defaultTypeName == null) {
            throw new InvalidDataAccessApiUsageException(
                    "The typeName is null in this context. Consider setting the defaultTypeName.");
        }

        Blob[] blobs = new Blob[values.size()];
        for (int i = 0; i < blobs.length; ++i) {
            Blob blob = conn.createBlob();
            blob.setBytes(1, values.get(i));
            blobs[i] = blob;
        }

        Array array = conn.unwrap(OracleConnection.class).createOracleArray(typeName != null ? typeName : defaultTypeName, blobs);
        return array;
    }
}