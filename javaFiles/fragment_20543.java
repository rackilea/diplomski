public void startProxyServer(String videoUrl) {
  int PORT = 28641; // random port
  File f = downloadFile(videoUrl);
  saveFile(f, '/path/to/server/storage');
  startWebServer('localhost', PORT);
}