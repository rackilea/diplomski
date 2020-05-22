public List<Attachment> download(List<Attachment> attachments) {
  ExecutorService executorService = Executors.newCachedThreadPool();
  List<Future<Attachment>> futures = new ArrayList<Future<Attachment>>();
  for (final Attachment attachment : attachments) {
    futures.add(executorService.submit(new Callable<Attachment>() {
      @Override
      public Attachment call() throws Exception {
        return doDownload(attachment);
      }
    }));
  }
  for (Future<Attachment> future: futures) {
    try {
      future.get();
    } catch (Exception ex) {
      // Do something
    }
  }
  return attachments;
}

private Attachment doDownload(Attachment attachment) throws Exception {
  attachment.setDownStatus("Failed");
  attachment.setDestLocation("C:\\Users\\attachments");
  String attUrl = attachment.getUrl();
  String fileName = attachment.getFileName();
  URL url = new URL(attUrl);
  File fileLocation = new File(attachment.getDestLocation(), fileName);
  FileUtils.copyURLToFile(url, fileLocation);
  if (fileLocation.exists()) {
    attachment.setDownStatus("Completed");
  }
  return attachment;
}