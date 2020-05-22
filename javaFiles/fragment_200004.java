@Autowired
PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
        persistentTokenBasedRememberMeServices.loginSuccess(request, response, auth);
    }