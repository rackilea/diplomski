public class X509KeySelector extends KeySelector {

PublicKey key;

/**
 * Constructor.
 *
 * @param key a public key of a certificate which need to be validated.
 */
public X509KeySelector(PublicKey key) {
    this.key = key;
}

/**
 * @return a KeySelectorResult with a predefined key.
 */
public KeySelectorResult select(KeyInfo keyInfo,
                                KeySelector.Purpose purpose,
                                AlgorithmMethod method,
                                XMLCryptoContext context) throws KeySelectorException {
    return new KeySelectorResult() {
        @Override
        public Key getKey() {
            return key;
        }
    };
}

}