public interface GenericListener {
    public void handleMyEvent(Object sourceObj, int eventCode);
}

//...later on there's some implementation
public void handleMyEvent(Object sourceObj, int eventCode) {
    if ( sourceObj == startDownloadButton && eventCode == MyButton.CLICKED ) {
        //... 20 lines of code to start download
    } else if ( sourceObj instanceOf DownloadStatus && eventCode == DownloadStatus.COMPLETE ) {
        //... 10 lines of code to display status
    } else //... and on and on...
}