public static MessageDigest getInstance(String algorithm)
    throws NoSuchAlgorithmException {
        try {
            Object[] objs = Security.getImpl(algorithm, "MessageDigest",
                                             (String)null);
            if (objs[0] instanceof MessageDigest) {
                MessageDigest md = (MessageDigest)objs[0];
                md.provider = (Provider)objs[1];
                return md;
            } else {
                MessageDigest delegate =
                    new Delegate((MessageDigestSpi)objs[0], algorithm);
                delegate.provider = (Provider)objs[1];
                return delegate;
            }
        } catch(NoSuchProviderException e) {
            throw new NoSuchAlgorithmException(algorithm + " not found");
        }
    }