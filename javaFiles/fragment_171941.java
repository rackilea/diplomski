public class MyCustomCertificate extends X509Certificate {

    // wraps a X509Certificate
    private X509Certificate cert;

    public MyCustomCertificate(X509Certificate cert) {
        this.cert = cert;
    }

    public void myCustomFunctionality1() {
        // do something with this.cert
    }

    public void myCustomFunctionality2() {
        // do something with this.cert
    }

    // delegate all X509Certificate methods to the wrapped certificate
    public PublicKey getPublicKey() {
        return this.cert.getPublicKey();
    }

    public Principal getSubjectDN() {
        return this.cert.getSubjectDN();
    }

    // and so on...
}