...                         
final long tmpStartTime = startTime;
final long tmpProcessedSize = processedSize;
final long tmpTotalSize = totalSize;
Display.getDefault().asyncExec(new Runnable() {

    @Override
    public void run() {
        showProgressInfo(tmpStartTime, tmpProcessedSize, tmpTotalSize);
    }
});
...