public class Ftp4jListener implements FTPDataTransferListener {
    private final ReadOnlyIntegerWrapper transfBytes = new ReadOnlyIntegerWrapper();
    private final ReadOnlyIntegerWrapper totalBytes = new ReadOnlyIntegerWrapper();
    private final ReadOnlyLongWrapper fileSize = new ReadOnlyLongWrapper(-1);

    public ReadOnlyIntegerProperty transfBytesProperty() {
        return transfBytes.getReadOnlyProperty() ;
    }

    public int getTransfBytes() {
        return transfBytesProperty().get();
    }

    // etc. for other two properties...

    private String fileName;
    ...
    @Override
    public void transferred(int length)
    {
        transfBytes.set(tranfBytes.get()+length);
        float percent = (float) transfBytes.get() / this.fileSize.get();
        float fPercent = percent*100;
        log.info("File: " + this.fileName + " | Bytes transfered "+ transfBytes.get() + " Percentage: " + fPercent + "%");
    }

}