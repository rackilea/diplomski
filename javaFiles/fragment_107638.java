X500NameStyle x500NameStyle = RFC4519Style.INSTANCE;

X500Name x500name = new JcaX509CertificateHolder( certificate ).getIssuer();
RDN[] rdns = x500name.getRDNs();
for ( RDN rdn : rdns ) {
    for ( AttributeTypeAndValue attribute : rdn.getTypesAndValues() ) {
        System.out.printf( "%s (%s) = %s%n",
                x500NameStyle.oidToDisplayName( attribute.getType() ),
                attribute.getType(),
                attribute.getValue()
        );
    }
}