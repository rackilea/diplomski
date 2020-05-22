public String getAccessLocation(X509Certificate certificate) throws IOException {

    final ASN1ObjectIdentifier ocspAccessMethod = X509ObjectIdentifiers.ocspAccessMethod;
    final byte[] authInfoAccessExtensionValue = certificate.getExtensionValue(X509Extension.authorityInfoAccess.getId());
    if (null == authInfoAccessExtensionValue) {

        return null;
    }
    ASN1InputStream ais1 = null;
    ASN1InputStream ais2 = null;
    try {

        final ByteArrayInputStream bais = new ByteArrayInputStream(authInfoAccessExtensionValue);
        ais1 = new ASN1InputStream(bais);
        final DEROctetString oct = (DEROctetString) (ais1.readObject());
        ais2 = new ASN1InputStream(oct.getOctets());
        final AuthorityInformationAccess authorityInformationAccess = AuthorityInformationAccess.getInstance(ais2.readObject());

        final AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
        for (AccessDescription accessDescription : accessDescriptions) {

            final boolean correctAccessMethod = accessDescription.getAccessMethod().equals(ocspAccessMethod);
            if (!correctAccessMethod) {

                continue;
            }
            final GeneralName gn = accessDescription.getAccessLocation();
            if (gn.getTagNo() != GeneralName.uniformResourceIdentifier) {
                //Not a uniform resource identifier
                continue;
            }
            final DERIA5String str = (DERIA5String) ((DERTaggedObject) gn.toASN1Primitive()).getObject();
            final String accessLocation = str.getString();

            return accessLocation;
        }
        return null;

    } finally {
        ais1.close();
        ais2.close();
    }
}