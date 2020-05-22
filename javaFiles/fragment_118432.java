private KeyInfo getKeyInfo(final Credential c, final String keyName) {

    final SecurityConfiguration secConfiguration =
            Configuration.getGlobalSecurityConfiguration();
    final NamedKeyInfoGeneratorManager namedKeyInfoGeneratorManager =
            secConfiguration.getKeyInfoGeneratorManager();
    final KeyInfoGeneratorManager keyInfoGeneratorManager =
            namedKeyInfoGeneratorManager.getDefaultManager();
    final KeyInfoGeneratorFactory keyInfoGeneratorFactory =
            keyInfoGeneratorManager.getFactory(c);
    final KeyInfoGenerator keyInfoGenerator = keyInfoGeneratorFactory.newInstance();
    KeyInfo keyInfo;

    keyInfo = keyInfoGenerator.generate(c);
    KeyInfoHelper.addKeyName(keyInfo,
            keyName);
    return keyInfo;
}