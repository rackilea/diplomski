private static final String SQL_GET_FILE_LIST = "select new FileObject(filename, size, id, type) from FileObject";

@Override
public List<FileObject> getFileList(String type) {
    // TODO Auto-generated method stub
    List<FileObject> files = hbTemplate.find(SQL_GET_FILE_LIST);
    hbTemplate.flush();
    return files;
}