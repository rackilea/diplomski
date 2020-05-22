public final class FileProcessor {

    private static FileProcessor instance = new FileProcessor();
    private Queue<File> filesToBeProcessedQueue = new ArrayBlockingQueue<File>(10);

    private FileProcessor() {
    }

    public static FileProcessor getInstance() {
        return instance;
    }

    public void run() {
        while (!filesToBeProcessedQueue.isEmpty()) {
            processSyncFiles(filesToBeProcessedQueue.poll());
        }
    }

    private void processSyncFiles(File inputFile) {
        try {
            HashMap<String, Boolean> outputConsolidation = new HashMap<String, Boolean>();

            FileReader fileReader = new FileReader(inputFile);
            List<InputBean> csvContentsList = CSVParser.readContentsFromCSV(fileReader, new InputBean());
            for (InputBean inputBean : csvContentsList) {
                boolean output = false;
                // some business logic
                outputConsolidation.put(inputBean.toString(), output);
            }
        } catch (Exception e) {
            //logging
        }
    }

    public synchronized Queue<File> getFilesToBeProcessedQueue() {
        return filesToBeProcessedQueue;
    }
}