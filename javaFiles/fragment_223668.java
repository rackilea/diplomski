@Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken)authentication;
        String username = userToken.getName();
        String password = (String) authentication.getCredentials();
          //Do whatevr you want with the credentials
         //Then populate the authorities for this credential
         YourPojo user=new YourPojo ();
         user.setUserName("add username");
        //set other details
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        //if user is admin add the below line
        GrantedAuthorityImpl grantedAuthorityImpl = new GrantedAuthorityImpl("eCommerceAdmin");
       //Add other authorities as applicable like 'user' etc.
       user.setAuthorities(grantedAuthorityList);
       return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());