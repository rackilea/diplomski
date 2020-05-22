ECPrivateKey ::= SEQUENCE {
 version        INTEGER { ecPrivkeyVer1(1) } (ecPrivkeyVer1),
 privateKey     OCTET STRING,
 parameters [0] ECParameters {{ NamedCurve }} OPTIONAL,
 publicKey  [1] BIT STRING OPTIONAL
}