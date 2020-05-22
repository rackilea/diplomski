protected X509Certificate extractCertificate(HttpServletRequest req) {
    X509Certificate[] certs = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
    if (null != certs && certs.length > 0) {
        return certs[0];
    }
    throw new RuntimeException("No X.509 client certificate found in request");
}