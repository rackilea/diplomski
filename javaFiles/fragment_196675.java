private final Logger LOGGER = LoggerFactory.getLogger(AbtractGetSDMapFunction.class);




/**
 * Namespace name
 */
public static final String NAMESPACE = "NameSpace";
private static final String ID = "id";
private Connection connection = null;
private static final String LINEID = "l";
private static final String CHANGE_LINE_ID = "clid";
private static final String CHANGE_LINE_DATE = "cld";
private String constClientPortHBase;
private String constQuorumHBase;
private int constTimeOutHBase;
private String constZnodeHBase;
public void initConnection() {
    Configuration conf = HBaseConfiguration.create();
    conf.setInt("timeout", constTimeOutHBase);
    conf.set("hbase.zookeeper.quorum", constQuorumHBase);
    conf.set("hbase.zookeeper.property.clientPort", constClientPortHBase);
    conf.set("zookeeper.znode.parent", constZnodeHBase);
    try {
        connection = HConnectionManager.createConnection(conf);
    } catch (Exception e) {
        LOGGER.error("Error in the configuration of the connection with HBase.", e);
    }
}

 public Tuple2<String, myInput> call(String row) throws Exception {
//this is where you need to init the connection for hbase to avoid serialization problem
    initConnection();

....do your work 
State state = getCurrentState(myInput.getKey());
....do your work 
}

public AbtractGetSDMapFunction( String constClientPortHBase, String constQuorumHBase, String constZnodeHBase, int constTimeOutHBase) {
    this.constClientPortHBase = constClientPortHBase;
    this.constQuorumHBase = constQuorumHBase;
    this.constZnodeHBase = constZnodeHBase;
    this.constTimeOutHBase = constTimeOutHBase;
}

/***************************************************************************/
/**
 * Table Name
 */
public static final String TABLE_NAME = "Table";

public state getCurrentState(String key) throws TechnicalException {
    LOGGER.debug("start key {}", key);
    String buildRowKey = buildRowKey(key);
    State currentState = new State();
    String columnFamily = State.getColumnFamily();
    if (!StringUtils.isEmpty(buildRowKey) && null != columnFamily) {
        try {
            Get scan = new Get(Bytes.toBytes(buildRowKey));
            scan.addFamily(Bytes.toBytes(columnFamily));
            addColumnsToScan(scan, columnFamily, ID);                
            Result result = getTable().get(scan);
            currentState.setCurrentId(getLong(result, columnFamily, ID));              
        } catch (IOException ex) {
            throw new TechnicalException(ex);
        }
        LOGGER.debug("end ");
    }
    return currentState;
}

/***********************************************************/

private Table getTable() throws IOException, TechnicalException {
    Connection connection = getConnection();
    // Table retrieve
    if (connection != null) {
        Table table = connection.getTable(TableName.valueOf(NAMESPACE, TABLE_NAME));


        return table;
    } else {
        throw new TechnicalException("Connection to Hbase not available");
    }
}

/****************************************************************/




private Long getLong(Result result, String columnFamily, String qualifier) {
    Long toLong = null;
    if (null != columnFamily && null != qualifier) {
        byte[] value = result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier));
        toLong = (value != null ? Bytes.toLong(value) : null);
    }
    return toLong;
}

private String getString(Result result, String columnFamily, String qualifier) {
    String toString = null;
    if (null != columnFamily && null != qualifier) {
        byte[] value = result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier));
        toString = (value != null ? Bytes.toString(value) : null);
    }
    return toString;
}


public Connection getConnection() {
    return connection;
}

public void setConnection(Connection connection) {
    this.connection = connection;
}



private void addColumnsToScan(Get scan, String family, String qualifier) {
    if (org.apache.commons.lang.StringUtils.isNotEmpty(family) && org.apache.commons.lang.StringUtils.isNotEmpty(qualifier)) {
        scan.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
    }
}

private String buildRowKey(String key) throws TechnicalException {
    StringBuilder rowKeyBuilder = new StringBuilder();
    rowKeyBuilder.append(HashFunction.makeSHA1Hash(key));
    return rowKeyBuilder.toString();
}