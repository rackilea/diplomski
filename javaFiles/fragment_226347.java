/**
 * Download the client.
 */
static void downloadFile() {
    try {
            URL url2 = new URL("http://lostredemption.com/LostRedemption.jar");
            InputStream in = new BufferedInputStream(url2.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in .read(buf))) {
                    out.write(buf, 0, n);
            }
            out.close(); 
            in .close();
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream(directory);
            fos.write(response);
            fos.close();
            //openDownloadClient();
    }
    catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to download latest client. Please check your internet connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            closeProgram();
    }
}