FileService fileService = FileServiceFactory.getFileService();
AppEngineFile appEngineFile = fileService.getBlobFile(new BlobKey(video.getBlobkey()));

String param = "4166764c675120921f348e64ca10148e8ff6d5df";
File binaryFile = new File(appEngineFile.getFullPath());
String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
String CRLF = "\r\n"; // Line separator required by multipart/form-data.

URLConnection connection = new URL(url).openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
BufferedOutputStream writer = null;

OutputStream output = connection.getOutputStream();
writer = new BufferedOutputStream(output); // true = autoFlush, important!

// Send normal param.
writer.write(("--" + boundary + CRLF).getBytes());
writer.write(("Content-Disposition: form-data; name=\"api_password\"" + CRLF).getBytes());
writer.write(("Content-Type: text/plain; charset=" + charset + CRLF).getBytes());
writer.write((CRLF).getBytes());
writer.write((param + CRLF).getBytes());
writer.flush();

// Send binary file.
writer.write(("--" + boundary + CRLF).getBytes());
writer.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + binaryFile.getName() + "\"" + CRLF).getBytes());
writer.write(("Content-Type: application/octet-stream" + CRLF).getBytes());
writer.write(("Content-Transfer-Encoding: binary" + CRLF).getBytes());
writer.write((CRLF).getBytes());
writer.flush();
InputStream input = null;
try {

    BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
    BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(new BlobKey(video.getBlobkey()));
    Long blobSize = blobInfo.getSize();

    //max read on fetch
    long maxReadFetch = 1015807;

    //read the file in one time temporary
    long i = 0;
    long start = 0;
    long end = 0;
    while(i < blobSize) {

        start = i;
        end = i + maxReadFetch;
        //determine end
        if(end > blobSize) {
            end = blobSize;
        } else {
            end--;
        }
        writer.write(blobstoreService.fetchData(new BlobKey(video.getBlobkey()), start, end));
        i += maxReadFetch;

    }

    writer.flush(); // Important! Output cannot be closed. Close of writer will close output as well.

} finally {
    if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
}
writer.write((CRLF).getBytes());
writer.flush(); // CRLF is important! It indicates end of binary boundary.

// End of multipart/form-data.
writer.write(("--" + boundary + "--" + CRLF).getBytes());
writer.flush();

//response part
InputStream responseStream = new BufferedInputStream(connection.getInputStream());

BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));

StringBuilder stringBuilder = new StringBuilder();
String line2;
while ((line2 = responseStreamReader.readLine()) != null)
{
    stringBuilder.append(line2).append("\n");
}
responseStreamReader.close();

String response = stringBuilder.toString(); //JSON data
return response;