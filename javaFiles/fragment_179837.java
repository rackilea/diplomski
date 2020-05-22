import java.io.File;
...
  File dir = new File(myDirectoryPath);
  File[] directoryListing = dir.listFiles();
  if (directoryListing != null) {
    for (File child : directoryListing) {
      // Do something with child
    }
  } else {
    // Handle the case where dir is not really a directory.
    // Checking dir.isDirectory() above would not be sufficient
    // to avoid race conditions with another process that deletes
    // directories.
  }