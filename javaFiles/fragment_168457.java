// Register default providers
private static void registerDefaultProviders() {
    secprops.put("security.provider.1", "org.apache.harmony.security.provider.cert.DRLCertFactory");  //$NON-NLS-1$ //$NON-NLS-2$
    secprops.put("security.provider.2", "org.apache.harmony.security.provider.crypto.CryptoProvider");  //$NON-NLS-1$ //$NON-NLS-2$
    secprops.put("security.provider.3", "org.apache.harmony.xnet.provider.jsse.JSSEProvider");  //$NON-NLS-1$ //$NON-NLS-2$
    secprops.put("security.provider.4", "org.bouncycastle.jce.provider.BouncyCastleProvider");  //$NON-NLS-1$ //$NON-NLS-2$
}