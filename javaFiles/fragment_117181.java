public class IdentifierLongType extends LongType implements IdentifierType {

@Override
public Object get(ResultSet rs, String name) throws SQLException {
    long i = rs.getLong(name);
    if (i == 0) {
        return null;
    } else {
        return Long.valueOf(i);
    }
}