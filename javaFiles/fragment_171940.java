public class MyCustomCertificate {

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

    // and so on...
}