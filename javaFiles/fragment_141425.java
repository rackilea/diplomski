private fun toEcPrivateKey(privateKey: String): ECPrivateKey {
        val ecKeyPair = ECKeyPair.create(Numeric.hexStringToByteArray(privateKey))

        val params = ECNamedCurveTable.getParameterSpec("secp256k1")
        val curveSpec = ECNamedCurveSpec("secp256k1", params.curve, params.g, params.n)

        val keySpec = java.security.spec.ECPrivateKeySpec(
            ecKeyPair.privateKey,
            curveSpec)

        val factory = KeyFactory.getInstance("ECDSA")
        return factory.generatePrivate(keySpec) as ECPrivateKey
}