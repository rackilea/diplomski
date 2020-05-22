public class HTableManager {

    public static int HTABLE_POOL_SIZE = 15;

    private static HTableManager instance;
    private static HTablePool hTablePool;

    /**
     * Private Constructor
     */
    private HTableManager() {
        try {
            Configuration config = HBaseConfiguration.create();
            config.set("hbase.defaults.for.version.skip", "false");

            hTablePool = new HTablePool(config, HTABLE_POOL_SIZE);
        } catch (IOException ex) {
            // Error handling
        }
    }

    /**
     * @return The HbaseTableManager instance
     */
    public static HTableManager getInstance() {
        if (instance == null) {
            instance = new HTableManager();
        }
        return instance;
    }

    /**
     * Method used to retrieve a HTable instance.
     * 
     * @param tableName The table name
     * @return The HTableInterface instance
     * @throws IOException 
     */
    public synchronized HTableInterface getHTable(String tableName) throws IOException {
        return hTablePool.getTable(tableName);
    }
}