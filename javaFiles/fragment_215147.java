boolean uploaded = ftpClient.storeFile("/wwwroot/preview/history.txt", inputStream);
if(!uploaded) {
    System.err.println("Can't upload File! Reply from Server: " + ftpClient.getReplyString());
} else {
    System.out.println("Upload successful");
}