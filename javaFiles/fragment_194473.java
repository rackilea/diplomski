// Obtain the list of files to process
File files[] = ...
List<File> fileList = Arrays.asList(files);

// Define the number of workers that should be used
int numWorkers = 10;

// Compute how many files each worker will process
int chunkSize = (int)Math.ceil((double)fileList.size() / numWorkers);

for (int i=0; i<numWorkers; i++) {

    // Compute the part of the "fileList" that the worker will process
    int minIndex = i * chunkSize;
    int maxIndex = i * chunkSize + chunkSize;
    maxIndex = Math.min(maxIndex, fileList.size());
    List<File> chunk = fileList.sublist(minIndex, maxIndex);

    // Start the worker
    processFiles(chunk);
}