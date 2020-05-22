public class CertVerification {


    public static void main(String[] args) throws Exception {

        String certificatePath = "C:\\Users\\user1\\Desktop\\test.cer";

        CertificateFactory cf = CertificateFactory.getInstance("X509");

        X509Certificate certificate = null;
        X509CRLEntry revokedCertificate = null;
        X509CRL crl = null;

        certificate = (X509Certificate) cf.generateCertificate(new FileInputStream(new File(certificatePath)));

        URL url = new URL("http://<someUrl from certificate>.crl");
        URLConnection connection = url.openConnection();

        try(DataInputStream inStream = new DataInputStream(connection.getInputStream())){

            crl = (X509CRL)cf.generateCRL(inStream);
        }

        revokedCertificate = crl.getRevokedCertificate(certificate.getSerialNumber());

        if(revokedCertificate !=null){
            System.out.println("Revoked");
        }
        else{
            System.out.println("Valid");
        }

    }


}