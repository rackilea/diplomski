public class CustomDelegate extends OracleDelegate {

    public CustomDelegate(Logger logger, String tablePrefix, String instanceId) {
        super(logger, tablePrefix, instanceId);
    }

    public CustomDelegate(Logger logger, String tablePrefix, String instanceId, Boolean useProperties) {
        super(logger, tablePrefix, instanceId, useProperties);
    }

    protected Object getObjectFromBlob(ResultSet rs, String colName)
            throws ClassNotFoundException, IOException, SQLException {
        byte[] data = rs.getBytes(colName);
        if (data == null || data.length == 0) {
            return null;
        }
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        try {
            return in.readObject();
        } finally {
            in.close();
        }
    }
}