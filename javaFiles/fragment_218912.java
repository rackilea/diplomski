public class Downloader {

    private static class ProgressListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // e.getSource() gives you the object of DownloadCountingOutputStream
            // because you set it in the overriden method, afterWrite().
            System.out.println("Downloaded bytes : " + ((DownloadCountingOutputStream) e.getSource()).getByteCount());
        }
    }

    public static void main(String[] args) {
        URL dl = null;
        File fl = null;
        String x = null;
        OutputStream os = null;
        InputStream is = null;
        ProgressListener progressListener = new ProgressListener();
        try {
            fl = new File(System.getProperty("user.home").replace("\\", "/") + "/Desktop/Screenshots.zip");
            dl = new URL("http://ds-forums.com/kyle-tests/uploads/Screenshots.zip");
            os = new FileOutputStream(fl);
            is = dl.openStream();

            DownloadCountingOutputStream dcount = new DownloadCountingOutputStream(os);
            dcount.setListener(progressListener);

            // this line give you the total length of source stream as a String.
            // you may want to convert to integer and store this value to
            // calculate percentage of the progression.
            dl.openConnection().getHeaderField("Content-Length");

            // begin transfer by writing to dcount, not os.
            IOUtils.copy(is, dcount);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
        }
    }
}