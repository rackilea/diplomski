InputStream crlStream = url.openStream();
        String stream = IOUtils.toString(crlStream);
        String tryPEM = "-----BEGIN X509CRL-----\n";
        tryPEM = tryPEM.concat(stream);
        tryPEM = tryPEM.concat("\n-----END X509CRL-----\n");
        System.out.println(tryPEM);
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509CRL) cf.generateCRL(IOUtils.toInputStream(tryPEM));