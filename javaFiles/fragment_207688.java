public class FolderPartitioner implements Partitioner {

    private static final Logger logger = LoggerFactory.getLogger(FolderPartitioner.class);

    private static final String DEFAULT_KEY_NAME = "fileName";

    private static final String PARTITION_KEY = "partition";

    private String folder;

    private String keyName = DEFAULT_KEY_NAME;

    /**
     * Map each partition to a subfolder of the folder property
     * {@link ExecutionContext}.
     * 
     */
    public Map<String, ExecutionContext> partition(int gridSize) {
        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(
                gridSize);
        int i = 0;
        File dir = new File(folder);
        File[] chunkList = dir.listFiles();
        for (File chunkStep : chunkList) {
            if (chunkStep.isDirectory()) {

                ExecutionContext context = new ExecutionContext();
                context.putString(keyName, chunkStep.getName());
                logger.info("Creating partition for folder:" + context.getString(keyName));
                map.put(PARTITION_KEY + i, context);
                i++;
            }
        }
        return map;
    }

    /**
     * The name of the key for the file name in each {@link ExecutionContext}.
     * Defaults to "fileName".
     * 
     * @param keyName
     *            the value of the key
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getFolder() {
        return folder;
    }

    /**
     * The name of the folder which contains the subfolders for spliting them to steps
     * 
     * @param folder
     */
    public void setFolder(String folder) {
        this.folder = folder;
    }

}