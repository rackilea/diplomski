public class Ftp4jListener implements FTPDataTransferListener {
    private int transfBytes=0;
    private int totalBytes=0;
    private long fileSize = -1;
    private String fileName;

    private final DoubleConsumer percentageCallback ;

    public Ftp4jListener(DoubleConsumer percentageCallback) {
        this.percentageCallback = percentageCallback ;
    }
    ...
    @Override
    public void transferred(int length)
    {
        transfBytes+=length;
        float percent = (float) transfBytes / this.fileSize;
        float fPercent = percent*100;

        percentageCallback.accept(fPercent);

        log.info("File: " + this.fileName + " | Bytes transfered "+ transfBytes + " Percentage: " + fPercent + "%");
    }
}