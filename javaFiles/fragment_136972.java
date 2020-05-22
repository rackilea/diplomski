private void openUrlInBrowser(String url)
{
 Runtime runtime = Runtime.getRuntime();
 String[] args = { "osascript", "-e", "open location \"" + url + "\"" };
 try
 {
  Process process = runtime.exec(args);
 }
 catch (IOException e)
 {
// do what you want with this
 }
}