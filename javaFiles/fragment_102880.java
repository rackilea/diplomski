CMSSignedData  dataParser = new CMSSignedData(trustBundleByte);
ContentInfo contentInfo = dataParser.getContentInfo();
SignedData signedData = SignedData.getInstance(contentInfo.getContent());

CMSSignedData encapInfoBundle = new CMSSignedData(new CMSProcessableByteArray(signedData.getEncapContentInfo().getContent().getDERObject().getEncoded()),contentInfo);
SignedData encapMetaData = SignedData.getInstance(encapInfoBundle.getContentInfo().getContent());

CMSProcessableByteArray cin = new CMSProcessableByteArray(((ASN1OctetString)encapMetaData.getEncapContentInfo().getContent()).getOctets());
CertificateFactory ucf = CertificateFactory.getInstance("X.509");

CMSSignedData  unsignedParser = new CMSSignedData(cin.getInputStream());
ContentInfo unsginedEncapInfo = unsignedParser.getContentInfo();
SignedData metaData = SignedData.getInstance(unsginedEncapInfo.getContent());
Enumeration certificates = metaData.getCertificates().getObjects();

// Build certificate path

while (certificates.hasMoreElements()) {
   DERObject certObj = (DERObject) certificates.nextElement();
   InputStream bin = new ByteArrayInputStream(certObj.getDEREncoded());
   X509Certificate cert = (X509Certificate) ucf.generateCertificate(bin);
 X500Name x500name = new JcaX509CertificateHolder(cert).getSubject();
RDN cn = x500name.getRDNs(BCStyle.CN)[0];
}