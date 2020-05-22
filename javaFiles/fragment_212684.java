BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
String path = ...;
String whatFind = ...;
FolderScan folderScan = new FolderScan(path, queue);
FileScan fileScan = new FileScan(whatFind, queue);

Executor executor = Executors.newCachecThreadPool();
executor.execute(folderScan);
executor.execute(fileScan);