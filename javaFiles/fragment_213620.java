/**
* Download a file's content.
*
* @param service Drive API service instance.
* @param file Drive File instance.
* @return InputStream containing the file's content if successful,
* {@code null} otherwise.
*/
private static InputStream downloadFile(Drive service, File file) {
    if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
        try {
            HttpResponse resp =
            service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl()))
            .execute();
            return resp.getContent();
        } catch (IOException e) {
            // An error occurred.
            e.printStackTrace();
            return null;
        }
    } else {
        // The file doesn't have any content stored on Drive.
        return null;
    }
}