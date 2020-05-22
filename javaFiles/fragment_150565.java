//Cache validated certificate's chain during session
    private final Set<UUID> chainCache;

    /*
     * Delegate to the default trust manager.
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        checkTrusted(chain, authType, false);
    }

    /*
     * Delegate to the default trust manager.
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        checkTrusted(chain, authType, true);
    }

     private void checkTrusted(X509Certificate[] chain, String authType, boolean server) throws CertificateException {
        // Internal class but Arrays.hashcode can be used in the same manner
        Digester digester = new Digester();
        //Digester will run through the array
        digester.digest(chain);
        digester.digest(authType);
        digester.digest(server);
        UUID uuid = digester.getUUID();
        //If the chain has been validated, no need top check again.
        if (chainCache.contains(uuid)) {
            return;
        }
       //Do stuff
     }