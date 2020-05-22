@Autowired
List<LogoutHandler> logoutHandlers;

@Autwired
LogoutSuccessHandler logoutSuccessHandler;

private void doLogout() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    for (LogoutHandler handler : handlers)
         handler.logout(request, response, auth);

    logoutSuccessHandler.onLogoutSuccess(request, response, auth);
}