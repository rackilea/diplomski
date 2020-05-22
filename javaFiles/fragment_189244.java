DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
tokenConverter.setUserTokenConverter(new DefaultUserAuthenticationConverter() {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        Authentication authentication = super.extractAuthentication(map);
        // User is my custom UserDetails class
        User user = new User();
        user.setSpecialKey(map.get("specialKey").toString());
        return new UsernamePasswordAuthenticationToken(user,
                authentication.getCredentials(), authentication.getAuthorities());
    }

});
tokenServices.setAccessTokenConverter(tokenConverter);