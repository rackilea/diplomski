.....

ExecutorService executorService = Executors.newSingleThreadExecutor();

.....

ResumableGDataFileUploader resumableUploader = new ResumableGDataFileUploader.Builder(service, new URL(
resumableVideoUploadURL), mediaFile, newEntry)
    .title(title)
    .chunkSize(chunkSize)
    .executor(executorService)
    .build();

resumableUploader.start();

while (!resumableUploader.isDone()) {
    Thread.sleep(progressInterval);
}

if (ResumableHttpFileUploader.UploadState.COMPLETE.equals(resumableUploader.getUploadState())) {
    ResponseMessage response = resumableUploader.getResponse();
    VideoEntry newVideo = new VideoEntry();
    newVideo.parseAtom(new ExtensionProfile(), response.getInputStream());
    extMsgId = newVideo.getHtmlLink().getHref();
}

executorService.shutdown();

.....