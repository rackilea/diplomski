FilenameFilter directoryFilter = new FilenameFilter() {
@Override
public boolean accept(File file, String name) {

     return new File(file, name).isDirectory();
}