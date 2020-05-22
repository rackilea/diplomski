@Mock
    private Principal principal;

    @Mock
    private SecurityContext securitycontext;

    @Mock
    private Authentication authentication;
     public void test() {
      LoggedInUser user = new LoggedInUser();
        Mockito.when(authentication.getPrincipal()).thenReturn(user);
        Mockito.when(securitycontext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securitycontext);
.......
.......
}