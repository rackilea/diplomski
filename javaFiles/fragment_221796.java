private @Autowired ErrorMessage errorMessage;    
@Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            try {
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();

                if (!credentials.checkUserExists(username)) {
                    //set something here
                }

                memberProfile = credentials.getUserInformation(username);

                if (passwordEncoder.matches(password, memberProfile.getPassword())) {
                    logger.info("It matches - encoder!");
                    return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities());
                } else {
                    //error message bean utilised here
                    errorMessage.setStatus("100");
                    errorMessage.setMessage(username + "'s password is incorrect");

                    throw new BadCredentialsException("The credentials provided are incorrect");
                }
            } catch (Exception ex) {
                throw new BadCredentialsException("The credentials provided are incorrect", ex);
            }
        }