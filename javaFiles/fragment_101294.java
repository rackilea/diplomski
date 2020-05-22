public class PatchedPostgreSQLPlatform extends PostgreSQLPlatform {

    /**
     * Extended with java.time.* classes mappings.
     */
    @Override
    public int getJDBCType(Class javaType) {
        if (javaType == ClassConstants.TIME_LDATE) {
            return Types.DATE;
        } else if (javaType == ClassConstants.TIME_LTIME) {
            return Types.TIMESTAMP;
        } else if (javaType == ClassConstants.TIME_LDATETIME) {
            return Types.TIMESTAMP;
        } else if (javaType == ClassConstants.TIME_ODATETIME) {
            return Types.TIMESTAMP;
        } else if (javaType == ClassConstants.TIME_OTIME) {
            return Types.TIMESTAMP;
        } else {
            return super.getJDBCType(javaType);
        }
    }

}