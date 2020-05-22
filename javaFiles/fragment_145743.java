Authentication authentication = SecurityContextHolder.getContext().getAuthentication();        
Object details = authentication.getDetails();        
if ( details instanceof OAuth2AuthenticationDetails ){
    OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)details;

    Map<String, Object> decodedDetails = (Map<String, Object>)oAuth2AuthenticationDetails.getDecodedDetails();

    System.out.println( "My custom claim value: " + decodedDetails.get("MyClaim") );
}