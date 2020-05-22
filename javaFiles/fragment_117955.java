public void printKeystore() {
    Field spiField = KeyStore.class.getDeclaredField("keyStoreSpi");
    spiField.setAccessible(true);
    KeyStoreSpi spi = (KeyStoreSpi) spiField.get(keystore1);
    Field entriesField = spi.getClass().getSuperclass().getDeclaredField("entries");
    entriesField.setAccessible(true);
    Collection entries = (Collection) entriesField.get(spi);
    for (Object entry : entries) {
        String alias = (String) invokeGetter(entry, "getAlias");
        Key privateKey = (Key) invokeGetter(entry, "getPrivateKey");
        X509Certificate[] certificateChain = (X509Certificate[]) invokeGetter(entry, "getCertificateChain");
        System.out.println(alias + ": " + privateKey + Arrays.toString(certificateChain));
    }
}

private Object invokeGetter(Object instance, String methodName)
        throws NoSuchMethodException, IllegalAccessException,
        InvocationTargetException {
    Method getAlias = instance.getClass().getDeclaredMethod(methodName);
    getAlias.setAccessible(true);
    return getAlias.invoke(instance);
}