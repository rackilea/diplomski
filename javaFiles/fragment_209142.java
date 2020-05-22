Response response = new Response() {
    @Override
    public int getStatus() {
        int samlStatus = SAMLResult.ResponseStatus;
        return samlStatus;
    }
    // override all other Response methods ...
}
return response;