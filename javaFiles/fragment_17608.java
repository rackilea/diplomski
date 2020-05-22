public class ClobUpdateTrigger extends TriggerAdapter {

    @Override
    public void fire(Connection connection, ResultSet oldRs, ResultSet newRs) throws SQLException {
        int generatedId = newRs.getInt(1);
        // We need to use reader to avoid internal casting problems
        String insertedClobValue = toString(newRs.getCharacterStream("clobvalue"));
        String updatedClobValue = insertedClobValue != null
                ? insertedClobValue.replace("##ID##", String.valueOf(generatedId))
                : null;
        newRs.updateString("clobvalue", updatedClobValue);
    }

    private static String toString(Reader reader) throws SQLException {
        try {
            StringWriter sw = new StringWriter();
            char[] buffer = new char[1024];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                sw.write(buffer, 0, read);
            }
            return sw.toString();
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}