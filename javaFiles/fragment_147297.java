public class SecurityContextThirdPartyTokenRetriever {

    public Serializable getThirdPartyToken() throws IllegalAccessException{
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        if(auth == null){
            throw new IllegalAccessException("Authentication is null in SecurityContext");
        }
        if(auth instanceof UsernamePasswordAuthenticationToken){
            Object details = auth.getDetails();
            if(details != null && details instanceof ThirdPartyValidationResponse){
                return ((ThirdPartyValidationResponse)details).getToken();
            }
        }
        return null;
    }

}