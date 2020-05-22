algorithms.put(X9ObjectIdentifiers.id_ecPublicKey, "ECDSA");
...
private KeyFactory getKeyFactory(AlgorithmIdentifier algId)
throws NoSuchAlgorithmException, NoSuchProviderException
{
  ASN1ObjectIdentifier algorithm = algId.getAlgorithm();
  String algName = (String)algorithms.get(algorithm);
...