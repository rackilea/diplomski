SignedData ::= SEQUENCE {
 version Version,
 digestAlgorithms DigestAlgorithmIdentifiers,
 contentInfo ContentInfo,
 certificates [0] IMPLICIT ExtendedCertificatesAndCertificates OPTIONAL,
 crls [1] IMPLICIT CertificateRevocationLists OPTIONAL,
 signerInfos SignerInfos }

DigestAlgorithmIdentifiers ::= SET OF DigestAlgorithmIdentifier

SignerInfos ::= SET OF SignerInfo