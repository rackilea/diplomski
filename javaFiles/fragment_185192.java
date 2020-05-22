private static final String SQL_GET_FILE_LIST = "select filename, size, id, type from FileObject";

@Override
public List<Object[]> getFileList(String type) {
    // TODO Auto-generated method stub
    List<Object[]> files = hbTemplate.find(SQL_GET_FILE_LIST);
    hbTemplate.flush();
    return files;
}