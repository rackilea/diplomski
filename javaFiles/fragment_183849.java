@Service
public class MyCustomAuthenticationProvider implements AuthenticationProvider{

        @Autowired
        private DaoAuthenticationProvider dbAuthProvider;

        @Autowired
        private ActiveDirectoryLdapAuthenticationProvider adAuthProvider;

        @Autowired
        UserDAO userDao;

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException{

            // Determine username
            String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED": authentication.getName();
            User user = userDao.getUserByName(username);
            if(user == null){
                throw new  AuthenticationException("Sorry. No this user.");
            }

            if(user.isAdUser()) {
                return adAuthProvider.authenticate(authentication);
            } else {
               return dbAuthProvider.authenticate(authentication);
            }

        }

        @Override
        public boolean supports(Class<?> authentication){
            return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        }


}