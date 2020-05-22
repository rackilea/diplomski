X509Certificate certs[] = 
    (X509Certificate[])req.getAttribute("javax.servlet.request.X509Certificate");
// ... Test if non-null, non-empty.

X509Certificate clientCert = certs[0];

// Get the Subject DN's X500Principal
X500Principal subjectDN = clientCert.getSubjectX500Principal();