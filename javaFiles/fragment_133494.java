if (System.getProperty("os.name").toLowerCase().contains("windows")) {
  String cmd = "rundll32 url.dll,FileProtocolHandler " + file.getCanonicalPath();
  Runtime.getRuntime().exec(cmd);
} 
else {
  Desktop.getDesktop().edit(file);
}