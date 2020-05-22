@Override
public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
    String userName = ((String) authentication.getPrincipal()).toLowerCase();
    String password = (String) authentication.getCredentials();
    if (userName != null && authentication.getCredentials() != null) {
            String clientId = getClientId();
            // validate client ID before use
            Set<String> userRoles = authRepository.getUserRoleDetails(userName.toLowerCase(), clientId);
            Collection<SimpleGrantedAuthority> authorities = fillUserAuthorities(userRoles);
            Authentication token =  new UsernamePasswordAuthenticationToken(userName, StringUtils.EMPTY, authorities);
            return token;
        } else {
            throw new BadCredentialsException("Authentication Failed!!!");
        }
     } else {
         throw new BadCredentialsException("Username or Password cannot be empty!!!");
     }         


private  String getClientId(){
    final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    final String authorizationHeaderValue = request.getHeader("Authorization");
    final String base64AuthorizationHeader = Optional.ofNullable(authorizationHeaderValue)
            .map(headerValue->headerValue.substring("Basic ".length())).orElse("");

    if(StringUtils.isNotEmpty(base64AuthorizationHeader)){
        String decodedAuthorizationHeader = new String(Base64.getDecoder().decode(base64AuthorizationHeader), Charset.forName("UTF-8"));
        return decodedAuthorizationHeader.split(":")[0];
    }

    return "";
}