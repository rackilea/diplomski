public class EarlyStartup implements IStartup {

    private static final String ALIAS = "ACME"; 

    @Override
    public void earlyStartup() {
        final char[] passphrase = "changeit".toCharArray();
        final char separator = File.separatorChar;
        final File dir = new File(System.getProperty("java.home") + separator + "lib" + separator + "security");
        final File file = new File(dir, "cacerts");

        try (InputStream certIn = getClass().getResourceAsStream("acme.org.crt");
                final InputStream localCertIn = new FileInputStream(file);) {

            final KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(localCertIn, passphrase);
            if (keystore.containsAlias(ALIAS)) {
                return;
            }

            final CertificateFactory cf = CertificateFactory.getInstance("X.509");
            final Certificate cert = cf.generateCertificate(certIn);
            keystore.setCertificateEntry(ALIAS, cert);

            try (OutputStream out = new FileOutputStream(file)) {
                keystore.store(out, passphrase);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}