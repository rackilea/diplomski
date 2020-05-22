oAuthscopes = "oauth2:"+"https://www.googleapis.com/auth/userinfo.email"+" "+"https://www.googleapis.com/auth/plus.login";

protected String fetchAccessToken() throws IOException{
    try {
        return GoogleAuthUtil.getToken(act, email, oAuthscopes);
    }
    catch(GooglePlayServicesAvailabilityException e){
        act.handleException(e);
    }
    catch(UserRecoverableAuthException e){
        act.handleException(e);
    }
    catch (GoogleAuthException e) {
        e.printStackTrace();
    }
    return null;
}