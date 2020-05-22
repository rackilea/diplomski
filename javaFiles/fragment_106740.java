@Override
    public boolean isValid(RealmModel realm, UserModel user, CredentialInput input) {
        // No need to check input is of type UserCredentialModel since there no need to cast it anymore
        if (!supportsCredentialType(input.getType())) return false;

        String password = properties.getProperty(user.getUsername());
        if (password == null) return false;
        // Input Password can now be obtained using the getChallengeResponse() method of the CredentialInput  type
        return password.equals(input.getChallengeResponse());
    }