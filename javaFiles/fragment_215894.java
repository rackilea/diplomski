PSourceAlgorithm ::= AlgorithmIdentifier {
      {PKCS1PSourceAlgorithms}
   }

  PKCS1PSourceAlgorithms    ALGORITHM-IDENTIFIER ::= {
       { OID id-pSpecified PARAMETERS EncodingParameters },
       ...  -- Allows for future expansion --
   }

  id-pSpecified    OBJECT IDENTIFIER ::= { pkcs-1 9 }

  EncodingParameters ::= OCTET STRING(SIZE(0..MAX))