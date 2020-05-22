Request         ::=     SEQUENCE {
   reqCert                     CertID,
   singleRequestExtensions     [0] EXPLICIT Extensions OPTIONAL }

CertID          ::=     SEQUENCE {
   hashAlgorithm       AlgorithmIdentifier,
   issuerNameHash      OCTET STRING, -- Hash of Issuer's DN
   issuerKeyHash       OCTET STRING, -- Hash of Issuers public key
   serialNumber        CertificateSerialNumber 
 }