public class HsmKeyManagerImpl implements X509KeyManager {
    ...

    @Override
    public PrivateKey getPrivateKey(String alias) {
        // HSM Vendor specific API calls
    }
}