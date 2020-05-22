public Map<String, Claim> getClaims() {
        Map<String, Claim> claims = new HashMap<>();

        String tokenValue = ((OAuth2AuthenticationDetails)((OAuth2Authentication) authenticationFacade.getAuthentication()).getDetails()).getTokenValue();
        try {
            DecodedJWT jwt = JWT.decode(tokenValue);
            claims = jwt.getClaims();
        } catch (JWTDecodeException ex) {
            LOGGER.info("Error decoding token value");
            LOGGER.error("Error decoding token value", ex);
        }

        return claims;
}