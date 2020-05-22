public class YourNavigationBean {

    private boolean uploadComplete; // <--- that's the property

    // ... your bean content, like constructors and stuff..
    // ...

    //a setter and a getter is needed, to here they are
    public boolean isUploadComplete() {
       return uploadComplete;
    }
    public void setUploadComplete(boolean uploadComplete) {
       this.uploadComplete = uploadComplete;
    }
}