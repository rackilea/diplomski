public class OAuth2AccessTokenToStringConverter implements Converter<OAuth2AccessToken, String> {

    @Override
    public String convert(final OAuth2AccessToken source) {
        //some code that takes your object and returns a String
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(source);
            //remove white space
            json = json.replace("\"scope\":\" ","\"scope\":\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}

public class OAuth2AuthenticationToStringConverter implements Converter<OAuth2Authentication, String> {

    @Override
    public  String convert(final OAuth2Authentication source) {
        //some code that takes your object and returns a String
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}


public class StringToOAuth2AccessTokenConverter implements Converter<String, OAuth2AccessToken> {

    @Override
    public OAuth2AccessToken convert(final String source) {
        //some code that takes a String and returns an object of your type
        ObjectMapper mapper = new ObjectMapper();
        OAuth2AccessToken deserialised = null;
        try {
            deserialised = mapper.readValue(source, OAuth2AccessToken.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deserialised;
    }
}


public class StringToOAuth2AuthenticationConverter implements Converter<String, OAuth2Authentication> {

    @Override
    public OAuth2Authentication convert(final String source) {
        // some code that takes a String and returns an object of your type
        OAuth2Authentication oAuth2Authentication = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode  rootNode = mapper.readTree(source);
            OAuth2Request oAuth2Request = getOAuth2Request(rootNode.get("oauth2Request"), mapper);
            JsonNode userAuthentication = rootNode.get("userAuthentication");
            JsonNode principal = userAuthentication.get("principal");
            UserAccount userAccount = mapper.readValue(principal.get("userAccount"), UserAccount.class);
            CTGUserDetails userDetails = new CTGUserDetails(userAccount);
            List<Map<String, String>> authorities = mapper.readValue(userAuthentication.get("authorities"), new TypeReference<List<Map<String, String>>>() {});
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, getAuthorities(authorities));
            oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oAuth2Authentication;
    }

    private OAuth2Request getOAuth2Request(final JsonNode jsonNode, ObjectMapper mapper) throws JsonParseException, JsonMappingException, IOException{
        Map<String, String> requestParameters = mapper.readValue(jsonNode.get("requestParameters"),new TypeReference<Map<String, String>>() {});
        String clientId = jsonNode.get("clientId").getTextValue();
        List<Map<String, String>> authorities = mapper.readValue(jsonNode.get("authorities"), new TypeReference<List<Map<String, String>>>() {});
        Set<String> scope = mapper.readValue(jsonNode.get("scope"), new TypeReference<HashSet<String>>() {});
        Set<String> resourceIds =   mapper.readValue(jsonNode.get("resourceIds"), new TypeReference<HashSet<String>>() {});
        return new OAuth2Request(requestParameters, clientId, getAuthorities(authorities) , true, scope, resourceIds, null, null, null);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            List<Map<String, String>> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(authorities.size());
        for (Map<String, String> authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.get("authority")));
        }
        return grantedAuthorities;
    }

}