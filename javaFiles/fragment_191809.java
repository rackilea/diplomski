@Autowired
public void authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder, final UserRepository userRepository, UserService userService) throws Exception {
    if(userRepository.count() == 0) {

        User user = new User();
        Role role = new Role();
        role.setName("SA");
        user.setEmail("test");
        user.setPassword("123");
        user.setRoles(Arrays.asList(role));
        user.setBlocked(false);
        user.setEnable(true);
        userService.save(user);
    }
   // authenticationManagerBuilder.userDetailsService(email -> {
   //     return userService.loadUserByUsername(email);
   // });
}