public class DownloadRunnable implements Runnable {

    @Override
    public void run() {
        FTPFileDownloader ftpdown = new FTPFileDownloader();
        try {
            ftpdown.downloadFiles(Configuration.array.get(0), Configuration.array.get(3), Configuration.array.get(4), Configuration.array.get(5), Configuration.array.get(6));
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        XmlToDB xmldb = new XmlToDB();
        ReadFilesFromFolder readfiles = new ReadFilesFromFolder();
        File file = new File("C:\\FTP_CLIENT_DIRECTORY\\");
        ArrayList<File> output = readfiles.listFilesForFolder(file, true, "");
        ArrayList<String> ss = null;
        try {
            ss = xmldb.XMLtoString(output);
            int nbrechang = xmldb.insert(ss);
        } catch (IOException | SAXException | ParserConfigurationException E) {
            // TODO Auto-generated catch block
            E.printStackTrace();
        }

        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}