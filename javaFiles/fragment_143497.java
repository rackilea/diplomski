CertStore store = response.getCertStore();
        Collection<? extends Certificate> certs = store
                .getCertificates(null);
        Certificate[] chain = new Certificate[certs.size()];
        int i = 0;
        for (Certificate certificate : certs) {
            chain[i++] = certificate;
        }