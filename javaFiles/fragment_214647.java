FileInputStream fr = new FileInputStream("jack.cer");
CertificateFactory cf = CertificateFactory.getInstance("X509");
X509Certificate crt = (X509Certificate) cf.generateCertificate(fr);

Attribute oc = new BasicAttribute("objectClass");
oc.add("person");
oc.add("inetOrgPerson");
oc.add("pkiCA");
Attributes entry = new BasicAttributes();
String entryDN=""Cn=test,dc=maxcrc,dc=com";
entry.put("sn", entryDN);
entry.put("cACertificate;binary", crt.getEncoded());
entry.put(oc);
try {
    ctx.createSubcontext(entryDN, entry);
} catch (NamingException e) {
    e.printStackTrace();
}