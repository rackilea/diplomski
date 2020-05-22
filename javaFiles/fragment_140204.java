public class FileCleaner extends DirectoryWalker {

    public FileCleaner() {
      super();
    }

    public List clean(File startDirectory) {
      List results = new ArrayList();
      walk(startDirectory, results);
      return results;
    }

    protected boolean handleDirectory(File directory, int depth, Collection results) {
      // delete svn directories and then skip
      if (".svn".equals(directory.getName())) {
        directory.delete();
        return false;
      } else {
        return true;
      }

    }

    protected void handleFile(File file, int depth, Collection results) {
      // delete file and add to list of deleted
      file.delete();
      results.add(file);
    }
  }