XMLSignature signature = fac.unmarshalXMLSignature(valContext);
KeyInfo keyInfo = signature.getKeyInfo();

Iterator iter = keyInfo.getContent().iterator();
X509CertImpl certImpl = null;
while (iter.hasNext()) {
    XMLStructure kiType = (XMLStructure) iter.next();
    if (kiType instanceof X509Data) {
        X509Data xd = (X509Data) kiType;
        Object[] entries = xd.getContent().toArray();
        X509CRL crl = null;
        for (int i = 0; ( i < entries.length); i++) {
            if (entries[i] instanceof X509CRL) {
                crl = (X509CRL) entries[i];
            }
            if (entries[i] instanceof X509CertImpl) {
                certImpl = (X509CertImpl) entries[i];
                try {
                    certImpl.checkValidity(signDate);
                } catch (CertificateExpiredException expiredEx) {
                    System.out.println("CERTIFICATE EXPIRED!");
                    return 1;
                } catch (CertificateNotYetValidException notYetValidEx) {
                    System.out.println("CERTIFICATE NOT VALID YET!");
                    return 0;
                }
                System.out.println("CERTIFICATE IS VALID!");                        
            }
        }
    }
}