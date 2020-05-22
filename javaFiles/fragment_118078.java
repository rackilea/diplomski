ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentType(mpf.getContentType());

String key = Util.getLoginUserName() + "/"
        + mpf.getOriginalFilename();
metadata.setContentLength(mpf.getSize());
PutObjectRequest putObjectRequest = new PutObjectRequest(
                Constants.S3_BUCKET_NAME, key, mpf.getInputStream(),
                metadata)
        .withStorageClass(StorageClass.ReducedRedundancy);

putObjectRequest.setProgressListener(new ProgressListener() {
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            System.out.println(progressEvent
                    .getBytesTransfered()
                    + ">> Number of byte transfered "
                    + new Date());
            progressEvent.getBytesTransfered();
            double totalByteRead = request
                    .getSession().getAttribute(
                                                    Constants.TOTAL_BYTE_READ) != null ? (Double) request
                                            .getSession().getAttribute(Constants.TOTAL_BYTE_READ) : 0;

            totalByteRead += progressEvent.getBytesTransfered();
            request.getSession().setAttribute(Constants.TOTAL_BYTE_READ, totalByteRead);
            System.out.println("total Byte read "+ totalByteRead);

            request.getSession().setAttribute(Constants.TOTAL_PROGRESS, (totalByteRead/size)*100);
        System.out.println("percentage completed >>>"+ (totalByteRead/size)*100);   
        if (progressEvent.getEventCode() == ProgressEvent.COMPLETED_EVENT_CODE) {
            System.out.println("completed  ******");
        }
    }
});
s3Client.putObject(putObjectRequest);