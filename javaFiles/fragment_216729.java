char[] password = …
final Credentials credentials = new UsernamePasswordCredentials(username, null) {
    @Override
    public String getPassword() {
        // AKCTAT-3791: this helps the GC to clear the String from the memory, as it will be used and dismissed immediately
        // Unfortunately Apache HTTP Client does not allow to pass the byte[] directly
        return new String(password);
    }
};
httpClient.getCredentialsProvider().setCredentials(ANY_AUTHSCOPE, (Credentials) auth.getCredentials());
// ... (do stuff with httpClient)
Arrays.fill(password, '\0');