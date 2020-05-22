readLogs(FileStrategy fileOrFtp){
  List<VirtualFile> directoryListing = fileOrFtp.listDirectory();
  for (VirtualFile myFolder : directoryListing) {
    ...
    ...
  }
}

interface FileStrategy {
  List<VirtualFile> listDirectory();
}

class FTPFileStrategy implements FileStrategy {
   // implement useFTP case (settings should be passed to the constructor
   // wrap each resulting FTPFile into a FTPFileAdapter
}

class LocalFileStrategy implements FileStrategy {
   // implement !useFTP case (settings, e.g. root folder should be passed to the constructor
   // wrap each resulting File into a FileAdapter
}