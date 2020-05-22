private void awsHoldUntilCompletedAndShowTransferProgress(Upload upload) throws InterruptedException, AmazonClientException {
        TransferProgress tProgress = upload.getProgress();
        long totalSize = tProgress.getTotalBytesToTransfer();
        long bPrevious = 0;
        int timerSec = Math.toIntExact(Math.round(Math.sqrt(totalSize / 1024 / 1024) / 4));// calculate based on file size
        if (timerSec > 60) {// no longer than 60 second per loop
            timerSec = 60;
        }
        while (!upload.isDone()) {
            long bTransferred = tProgress.getBytesTransferred();
            String strMbps = Double.valueOf((((bTransferred - bPrevious) / timerSec) / 1024) / 1024).toString() + " MBps";
            String strTransfered = bTransferred + " bytes";
            if (bTransferred > 1024) {
                strTransfered = Double.valueOf((bTransferred / 1024) / 1024).toString() + " MB";
            }
            log.info("Upload progress: "
                    + strTransfered
                    + " / "
                    + FileUtils.byteCountToDisplaySize(totalSize) + " - "
                    + Math.round(tProgress.getPercentTransferred()) + "% "
                    + strMbps);

            bPrevious = bTransferred;
            TimeUnit.SECONDS.sleep(timerSec);
        }

        Transfer.TransferState transferState = upload.getState();
        log.info("Final transfer state: " + transferState);

        if (transferState == Transfer.TransferState.Failed) {
            throw upload.waitForException();
        }
}