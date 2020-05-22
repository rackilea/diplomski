public class MyMultiDataObject extends MultiDataObject {

    public MyMultiDataObject(FileObject fileObj, DataLoader loader)
            throws DataObjectExistsException {
        super(fileObj, loader);
        getCookieSet().add(new MyOpenCookie());
    }

    private class MyOpenCookie implements OpenCookie {
        public void open(){
            //Open your desired TopCompnent; Call your current double click action that has the desired behavior
        }
    }
}