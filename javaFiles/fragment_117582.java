val kpg: KeyPairGenerator = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_EC,
    "AndroidKeyStore")
val parameterSpec: KeyGenParameterSpec = KeyGenParameterSpec.Builder("alias",
    KeyProperties.PURPOSE_SIGN).run {
    setDigests(KeyProperties.DIGEST_SHA256)
    build()
    }
kpg.initialize(parameterSpec)
val keyPair = kpg.generateKeyPair()