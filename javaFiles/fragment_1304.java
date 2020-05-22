public String readICS() throws IOException {
    String fileUrl = "http://..."; //ICS-Url
    BufferedInputStream in = null;
    String ics = null;
    try {
        in = new BufferedInputStream(new URL(fileUrl).openStream());
        byte data[] = new byte[1024];
        while (in.read(data, 0, 1024) != -1) {
            ics = ics + new String(data);
        }
     } finally {
         if (in != null)
             in.close();
    }
    return ics;
}