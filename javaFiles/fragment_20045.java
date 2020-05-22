HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

connection = new Connection(new URL("https://" +           target.getHostname()));

log.debug(String.format("logging in to '%s'...", target.getHostname()));
Session.loginWithPassword(connection, target.getUsername(), target.getPassword(), APIVersion.latest().toString());
log.debug("Success! Session API version is %s", connection.getAPIVersion().toString());