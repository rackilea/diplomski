public void getEquipment(HttpServletRequest request, HttpServletResponse response) {
    Application application = client.getResource(applicationRestUrl, Application.class);

    OauthAuthenticationResult result = (OauthAuthenticationResult) application.authenticateOauthRequest(request).execute();

    System.out.println(result.getApiKey());
    System.out.println(result.getAccount());

    //Return what you need to return in the response
    handleEquipmentRequest(response);
}