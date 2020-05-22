public class PdfFileReader {
    public static void main(String[] args) throws IOException {

        URL pdfUrl = new URL("http://www.crdp-strasbourg.fr/je_lis_libre/livres/Anonyme_LesMilleEtUneNuits1.pdf");
        byte[] ba1 = new byte[1024];
        int baLength;
        try (FileOutputStream fos1 = new FileOutputStream("c:\\mybook.pdf")) {
            URLConnection urlConn = pdfUrl.openConnection();
            System.out.println("The content type is: " + urlConn.getContentType());

            try {
                InputStream is1 = pdfUrl.openStream();
                while ((baLength = is1.read(ba1)) != -1) {
                    fos1.write(ba1, 0, baLength);
                }
                fos1.flush();
                fos1.close();
                is1.close();


            } catch (ConnectException ce) {
                System.out.println("FAILED.\n[" + ce.getMessage() + "]\n");
            }
        }
    }
}