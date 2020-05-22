import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.commons.codec.binary.Base64;

class LoadKey {
    public static void main(String[] args)
    throws Exception
    {
        String cert = "-----BEGIN CERTIFICATE-----\n" +
                      "MIIDITCCAoqgAwIBAgIQT52W2WawmStUwpV8tBV9TTANBgkqhkiG9w0BAQUFADBM\n" +
                      "MQswCQYDVQQGEwJaQTElMCMGA1UEChMcVGhhd3RlIENvbnN1bHRpbmcgKFB0eSkg\n" +
                      "THRkLjEWMBQGA1UEAxMNVGhhd3RlIFNHQyBDQTAeFw0xMTEwMjYwMDAwMDBaFw0x\n" +
                      "MzA5MzAyMzU5NTlaMGgxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlh\n" +
                      "MRYwFAYDVQQHFA1Nb3VudGFpbiBWaWV3MRMwEQYDVQQKFApHb29nbGUgSW5jMRcw\n" +
                      "FQYDVQQDFA53d3cuZ29vZ2xlLmNvbTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkC\n" +
                      "gYEA3rcmQ6aZhc04pxUJuc8PycNVjIjujI0oJyRLKl6g2Bb6YRhLz21ggNM1QDJy\n" +
                      "wI8S2OVOj7my9tkVXlqGMaO6hqpryNlxjMzNJxMenUJdOPanrO/6YvMYgdQkRn8B\n" +
                      "d3zGKokUmbuYOR2oGfs5AER9G5RqeC1prcB6LPrQ2iASmNMCAwEAAaOB5zCB5DAM\n" +
                      "BgNVHRMBAf8EAjAAMDYGA1UdHwQvMC0wK6ApoCeGJWh0dHA6Ly9jcmwudGhhd3Rl\n" +
                      "LmNvbS9UaGF3dGVTR0NDQS5jcmwwKAYDVR0lBCEwHwYIKwYBBQUHAwEGCCsGAQUF\n" +
                      "BwMCBglghkgBhvhCBAEwcgYIKwYBBQUHAQEEZjBkMCIGCCsGAQUFBzABhhZodHRw\n" +
                      "Oi8vb2NzcC50aGF3dGUuY29tMD4GCCsGAQUFBzAChjJodHRwOi8vd3d3LnRoYXd0\n" +
                      "ZS5jb20vcmVwb3NpdG9yeS9UaGF3dGVfU0dDX0NBLmNydDANBgkqhkiG9w0BAQUF\n" +
                      "AAOBgQAhrNWuyjSJWsKrUtKyNGadeqvu5nzVfsJcKLt0AMkQH0IT/GmKHiSgAgDp\n" +
                      "ulvKGQSy068Bsn5fFNum21K5mvMSf3yinDtvmX3qUA12IxL/92ZzKbeVCq3Yi7Le\n" +
                      "IOkKcGQRCMha8X2e7GmlpdWC1ycenlbN0nbVeSv3JUMcafC4+Q==\n" +
                      "-----END CERTIFICATE-----\n";

        cert = cert.replace("-----BEGIN CERTIFICATE-----\n", "");
        cert = cert.replace("-----END CERTIFICATE-----\n", "");
        System.out.println(cert);

        byte[] encodedCert = cert.getBytes("UTF-8");
        byte[] decodedCert = Base64.decodeBase64(encodedCert);
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        InputStream in = new ByteArrayInputStream(decodedCert);
        X509Certificate certificate = (X509Certificate)certFactory.generateCertificate(in);

        System.out.println("Subject DN : " + certificate.getSubjectDN().getName());
        System.out.println("Issuer : " + certificate.getIssuerDN().getName());
        System.out.println("Not After: " + certificate.getNotAfter());
        System.out.println("Not Before: " + certificate.getNotBefore());
        System.out.println("version: " + certificate.getVersion());
        System.out.println("serial number : " + certificate.getSerialNumber());

        PublicKey publicKey = certificate.getPublicKey();
        System.out.println("PublicKey : \n" + publicKey);
    }
}