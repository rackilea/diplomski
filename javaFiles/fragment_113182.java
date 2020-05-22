URL url = new URL("file:///" + dir + "/reports.csv");
FileURLConnection urlConn = (FileURLConnection) url.openConnection();
String contentType = "text/csv";
ApplicationInstance.getActive().enqueueCommand(new DownloadCommand(
    new FileDownload(contentType,"inline", 
                     filename.toString(), 
                     urlConn.getInputStream())));