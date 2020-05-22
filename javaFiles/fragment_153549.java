bool success = true;
try {
  (new Socket(host, port)).close();
} catch (UnknownHostException e) {
  // unknown host
  success = false;
} catch (IOException e) {
  // io exception, service probably not running
  success = false;
}