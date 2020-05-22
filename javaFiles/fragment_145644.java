public X509CertificateHolder loadSigner() throws FileNotFoundException, IOException {
    InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.crt");
    PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
    return (X509CertificateHolder) parser.readObject();
}

public PrivateKeyInfo loadInKey() throws FileNotFoundException, IOException {
    InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.key");
    PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
    return (PrivateKeyInfo) parser.readObject();
}

public X509CertificateHolder loadCertfile() throws FileNotFoundException, IOException {
    InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.crt");
    PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
    return (X509CertificateHolder) parser.readObject();
}