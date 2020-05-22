public UploadValuePage(PageParameters parameters) {
    super(parameters);
    Bytes maxSize = Bytes.kilobytes(20000);
    ServletWebRequest swr = (ServletWebRequest) getRequest();
    MultipartServletWebRequest mswr = swr.newMultipartWebRequest(maxSize, "uploadId");
    mswr.parseFileParts(); // since Wicket 6.18.0
    FileItem item = mswr.getFile("fileInput").get(0);
    // process item
}