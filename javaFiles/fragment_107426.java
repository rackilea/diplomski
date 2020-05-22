package com.cert.example.main;

import java.io.IOException;
import java.io.StringReader;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;

public class CertificateDecoder {

    public static void main(String[] args) throws IOException {

        String certStr = "-----BEGIN CERTIFICATE-----\r\n" + 
                "MIIIzwYJKoZIhvcNAQcCoIIIwDCCCLwCAQExDzANBglghkgBZQMEAgEFADALBgkq\r\n" + 
                "hkiG9w0BBwGgggZbMIIGVzCCBT+gAwIBAgIELhJ2QDANBgkqhkiG9w0BAQUFADCB\r\n" + 
                "mDELMAkGA1UEBhMCREUxEDAOBgNVBAoMB1NpZW1lbnMxETAPBgNVBAUTCFpaWlpa\r\n" + 
                "WlkyMTowOAYDVQQLDDFDb3B5cmlnaHQgKEMpIFNpZW1lbnMgQUcgMjAxMyBBbGwg\r\n" + 
                "UmlnaHRzIFJlc2VydmVkMSgwJgYDVQQDDB9TaWVtZW5zIElzc3VpbmcgQ0EgRUUg\r\n" + 
                "QXV0aCAyMDEzMB4XDTE0MDcxODEzNTcwM1oXDTE3MDcxODEzNTcwM1owYzERMA8G\r\n" + 
                "A1UEBRMIWjAwMzBBTUgxDzANBgNVBCoMBkFsZXhleTERMA8GA1UEBAwIU2Vkb3lr\r\n" + 
                "aW4xEDAOBgNVBAoMB1NpZW1lbnMxGDAWBgNVBAMMD1NlZG95a2luIEFsZXhleTCC\r\n" + 
                "ASAwCwYJKoZIhvcNAQEBA4IBDwAwggEKAoIBAQCKahNgWzDPSnOwba2ljWQb8Lni\r\n" + 
                "uvAGZHEvdd5zm8H7Kw56WMxdixKHoKSChXWf1zGE3RZAsQOdHOpcgiqnRF2xLe2l\r\n" + 
                "LjCLoE9sC4DfUVD4mKe3kcxtnsxkoLc1A/3QXJSOzpk7rPJeqehmuj06yCtPjpdF\r\n" + 
                "Gmtf4bkskiQuK8u4RJfnmzffWQppd2Ld+u8tLxQKyHnZtOnPyYQGRQJXJKhruDnn\r\n" + 
                "LonlveVXKzEzmo88E5udB+/6jDWDfuyfKHMFyOhk80qGeYDOYQHxiq/PJbAyQU6X\r\n" + 
                "PONbfsCgILKxx7uHaBlhNALxjFZSeNNtfg0bx82O1DoJEcWcOjZQtQMuNUjvAgMB\r\n" + 
                "AAGjggLdMIIC2TAdBgNVHQ4EFgQUE5jDSnfWWnlUWMKztQ6zYfgohUkwUwYDVR0R\r\n" + 
                "BEwwSqArBgorBgEEAYI3FAIDoB0MG2FsZXhleS5zZWRveWtpbkBzaWVtZW5zLmNv\r\n" + 
                "bYEbYWxleGV5LnNlZG95a2luQHNpZW1lbnMuY29tMA4GA1UdDwEB/wQEAwIHgDCC\r\n" + 
                "AQQGCCsGAQUFBwEBBIH3MIH0MDIGCCsGAQUFBzAChiZodHRwOi8vYWguc2llbWVu\r\n" + 
                "cy5jb20vcGtpP1paWlpaWlkyLmNydDBBBggrBgEFBQcwAoY1bGRhcDovL2FsLnNp\r\n" + 
                "ZW1lbnMubmV0L0NOPVpaWlpaWlkyLEw9UEtJP2NBQ2VydGlmaWNhdGUwSQYIKwYB\r\n" + 
                "BQUHMAKGPWxkYXA6Ly9hbC5zaWVtZW5zLmNvbS9DTj1aWlpaWlpZMixvPVRydXN0\r\n" + 
                "Y2VudGVyP2NBQ2VydGlmaWNhdGUwMAYIKwYBBQUHMAGGJGh0dHA6Ly9vY3NwLnBr\r\n" + 
                "aS1zZXJ2aWNlcy5zaWVtZW5zLmNvbTAfBgNVHSMEGDAWgBTelD9Lal9YThQYyUbX\r\n" + 
                "FDnCnCE8KTAMBgNVHRMBAf8EAjAAMBoGA1UdIAQTMBEwDwYNKwYBBAGhaQcCAgMB\r\n" + 
                "ATCBygYDVR0fBIHCMIG/MIG8oIG5oIG2hiZodHRwOi8vY2guc2llbWVucy5jb20v\r\n" + 
                "cGtpP1paWlpaWlkyLmNybIZBbGRhcDovL2NsLnNpZW1lbnMubmV0L0NOPVpaWlpa\r\n" + 
                "WlkyLEw9UEtJP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3SGSWxkYXA6Ly9jbC5z\r\n" + 
                "aWVtZW5zLmNvbS9DTj1aWlpaWlpZMixvPVRydXN0Y2VudGVyP2NlcnRpZmljYXRl\r\n" + 
                "UmV2b2NhdGlvbkxpc3QwMwYDVR0lBCwwKgYIKwYBBQUHAwIGCCsGAQUFBwMEBgor\r\n" + 
                "BgEEAYI3FAICBggrBgEFBQgCAjANBgkqhkiG9w0BAQUFAAOCAQEAmzrYxmkRuSPM\r\n" + 
                "itK0rnR98BXlnB88ldVXjyz+rjHg9QghoZ5+8u7wHnxMSXida4XvYbhN5maUQs3D\r\n" + 
                "dWebvXP6CXt/OErVgYHlEAT8d5iqvin7/6eEgS0ge9DOxD2Rv+LYltPmAsjgxUS/\r\n" + 
                "0MecbUJpyBct6mDNfPI7riCu+mCcw6v9OKLWnXTIZsV9Z/WqaFbqVeJ5wo1+MUGW\r\n" + 
                "CGrDVkn7XnCKAQN8xEEO+Dq/TSVyv8tlDUzWps1yb3l9cYDc030s5AwFXa99v76p\r\n" + 
                "YJUZ08qQsieXOrs3qyQxMalM/Y042N17bwf9XkGT6iKN8o8U0YS1Vkaz8iroBRKk\r\n" + 
                "iA2pRNN4AjGCAjgwggI0AgEBMIGhMIGYMQswCQYDVQQGEwJERTEQMA4GA1UECgwH\r\n" + 
                "U2llbWVuczERMA8GA1UEBRMIWlpaWlpaWTIxOjA4BgNVBAsMMUNvcHlyaWdodCAo\r\n" + 
                "QykgU2llbWVucyBBRyAyMDEzIEFsbCBSaWdodHMgUmVzZXJ2ZWQxKDAmBgNVBAMM\r\n" + 
                "H1NpZW1lbnMgSXNzdWluZyBDQSBFRSBBdXRoIDIwMTMCBC4SdkAwDQYJYIZIAWUD\r\n" + 
                "BAIBBQCgaTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEP\r\n" + 
                "Fw0xNzA1MDMxNDI3NTFaMC8GCSqGSIb3DQEJBDEiBCBCA/fR9wGftKzKFZRuIDJV\r\n" + 
                "bYiaHzsDteoUoUL55kMrYDANBgkqhkiG9w0BAQEFAASCAQA6HtP3xr36VLj+WMao\r\n" + 
                "PRrszLfMJTE7lKIX3Vjybj2W3yj4qanPamZBb4KyEDIvQA8r65j4dbzcDePoFsRB\r\n" + 
                "5eYRnfB/djuXPAZdL9xdFMH3iRzfcseSFXulZ8FrG/9cuqDQkYVIx/Fk43yLtlpx\r\n" + 
                "OncVG3vZVW306yKQLu7Tsy+/GEkNDBMt6akqNPWp+9zqQTj7TaCXg7qr7mTlSStZ\r\n" + 
                "E15USoAOelisALpwPdizvfaJOqP03IobwDXMfRaCjzEANVl/M3woL1sNLu6BtuMe\r\n" + 
                "mAdls8tnJWDF+wpD4Y256Dso4FvDe2iK923jNElzq4iyc6ZosqGORS3nTh/1FQyp\r\n" + 
                "gkC1\r\n" + 
                "-----END CERTIFICATE-----";

        // Init bouncycastle
        Security.addProvider(new BouncyCastleProvider());

        // Get certificate
        StringReader sr = new StringReader(certStr);
        PEMReader pr = new PEMReader(sr);
        X509Certificate cert = (X509Certificate)pr.readObject();
        pr.close();

        // Get Public Key as RSA in order to get extra attributes
        RSAPublicKey rsaPublicKey = (RSAPublicKey)cert.getPublicKey();

        System.out.println(printCertInfo(cert, rsaPublicKey));
    }

    static String printCertInfo(X509Certificate cert, RSAPublicKey rsaPublicKey) {
        StringBuilder sb = new StringBuilder();

        sb.append("Certificate:\r\n");
        sb.append("Data:\r\n");
        sb.append("\tVersion: " + cert.getVersion() + "\r\n");
        sb.append("\tSerial Number: " + cert.getSerialNumber() + "\r\n");
        sb.append("\tSignature Algorithm: " + cert.getSigAlgName() + "\r\n");
        sb.append("\tIssuer: " + cert.getIssuerDN().getName() + "\r\n");
        sb.append("\tSignature Algorithm: " + cert.getSigAlgName() + "\r\n");
        sb.append("\tValidity\r\n");
        sb.append("\t\tNot Before: " + cert.getNotBefore() + "\r\n");
        sb.append("\t\tNot After: " + cert.getNotAfter() + "\r\n");
        sb.append("\tSubject: " + cert.getSubjectDN() + "\r\n");
        sb.append("\tSubject Public Key Info:\r\n");
        sb.append("\t\tPublic Key Algorithm: " + rsaPublicKey.getAlgorithm() + "\r\n");
        sb.append("\t\t\tPublic-Key: " + rsaPublicKey.getModulus().bitLength() + " bit \r\n");
        sb.append("\t\t\tModulus:\r\n");
        sb.append("\t\t\t\t" + rsaPublicKey.getModulus().toString(16) + "\r\n");
        sb.append("\t\t\tExponent: " + rsaPublicKey.getPublicExponent() + "\r\n");

        // TODO: Print other attributes, do some research to get them all...

        return sb.toString();
    }

}