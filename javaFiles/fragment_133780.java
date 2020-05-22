public class MyMultiDataObject extends MultiDataObject {

    public MyMultiDataObject(FileObject fileObj, DataLoader loader)
            throws DataObjectExistsException {
        super(fileObj, loader);
        registerEditor("text/experiment+xml", true);
    }
}