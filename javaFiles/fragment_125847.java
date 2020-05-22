X509Certificate cert = ...;

X500Name x500name = new JcaX509CertificateHolder(cert).getSubject();
RDN cn = x500name.getRDNs(BCStyle.CN)[0];

return IETFUtils.valueToString(cn.getFirst().getValue());