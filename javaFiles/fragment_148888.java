HashMap<String, String> authorizationParameters = new HashMap<String, String>();
        authorizationParameters.put("scope", "read");
        authorizationParameters.put("username", "mobile_client");
        authorizationParameters.put("client_id", "mobile-client");
        authorizationParameters.put("grant", "password");

        DefaultAuthorizationRequest authorizationRequest = new DefaultAuthorizationRequest(authorizationParameters);
        authorizationRequest.setApproved(true);

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_UNTRUSTED_CLIENT"));
        authorizationRequest.setAuthorities(authorities);

        HashSet<String> resourceIds = new HashSet<String>();
        resourceIds.add("mobile-public");
        authorizationRequest.setResourceIds(resourceIds);

        // Create principal and auth token
        User userPrincipal = new User(user.getUserID(), "", true, true, true, true, authorities);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities) ;

        OAuth2Authentication authenticationRequest = new OAuth2Authentication(authorizationRequest, authenticationToken);
        authenticationRequest.setAuthenticated(true);

        CustomTokenStore tokenStore = new CustomTokenStore();

        // Token Enhancer
        CustomTokenEnhancer tokenEnhancer = new CustomTokenEnhancer(user.getUserID());

        CustomTokenServices tokenServices = new CustomTokenServices();
        tokenServices.setTokenEnhancer(tokenEnhancer);
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);

        OAuth2AccessToken accessToken = tokenServices.createAccessTokenForUser(authenticationRequest, user);