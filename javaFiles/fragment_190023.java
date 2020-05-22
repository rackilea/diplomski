// Read the CSR
FileReader fileReader = new FileReader("/path/to/your.csr");
PemReader pemReader = new PemReader(fileReader);

PKCS10CertificationRequest csr = 
    new PKCS10CertificationRequest(pemReader.readPemObject().getContent());

pemReader.close();
fileReader.close();

// Write the Public Key as a PEM-File
StringWriter output = new StringWriter();
PemWriter pemWriter = new PemWriter(output);

PemObject pkPemObject = new PemObject("PUBLIC KEY", 
    csr.getSubjectPublicKeyInfo().getEncoded());

pemWriter.writeObject(pkPemObject);
pemWriter.close();

System.out.println(output.getBuffer());

// Extract the Public Key as "RSAKeyParameters" so you can use for
// encryption/signing operations.
RSAKeyParameters pubkey = 
    (RSAKeyParameters)PublicKeyFactory.createKey(csr.getSubjectPublicKeyInfo());