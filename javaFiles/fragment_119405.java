public static String toString(final Clob clob)
    throws SQLException, IOException {

    if (clob == null) {
        return "";
    }

    Long length = null;

    // try to get the oracle specific CLOB length
    // no vendor-specific code here.
    try {
        final Class<?> oracleClobClass = Class.forName("oracle.sql.CLOB");
        if (oracleClobClass.isInstance(clob)) {
            length = (Long) oracleClobClass.getMethod("getLength", null)
                     .invoke(clob, null);
        }
    } catch (final Exception e) {
    }

    // we can set initial capacity if we got the length.
    final StringBuilder builder
        = length == null
        ? new StringBuilder() : new StringBuilder(length.intValue());

    final BufferedReader reader
        = new BufferedReader(clob.getCharacterStream());
    for (String line = null; (line = reader.readLine()) != null; ) {
        builder.append(line);
    }

    return builder.toString();
}