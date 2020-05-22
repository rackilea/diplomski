ASN1EncodableVector alternativeNames = new ASN1EncodableVector();
for( String domainName : domainNames )
{
  alternativeNames.add( new GeneralName( GeneralName.dNSName, domainName ) );
}
certGenerator.addExtension( X509Extensions.SubjectAlternativeName, false, new GeneralNames( new DERSequence( alternativeNames ) ) );