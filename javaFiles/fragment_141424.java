private fun toEcPublicKey(publicKey: String): ECPublicKey {
        val params = ECNamedCurveTable.getParameterSpec("secp256k1")
        val curveSpec = ECNamedCurveSpec("secp256k1", params.curve, params.g, params.n)

        //This is the part how to generate ECPoint manually from public key string.
        val pubKeyX = publicKey.substring(0, publicKey.length / 2)
        val pubKeyY = publicKey.substring(publicKey.length / 2)
        val ecPoint = ECPoint(BigInteger(pubKeyX, 16), BigInteger(pubKeyY, 16))

        val params2 = EC5Util.convertSpec(curveSpec.curve, params)

        val keySpec = java.security.spec.ECPublicKeySpec(ecPoint, params2)
        val factory = KeyFactory.getInstance("ECDSA")
        return factory.generatePublic(keySpec) as ECPublicKey
}