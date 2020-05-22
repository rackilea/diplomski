@Bean
public UserDetailsService userDetailsService() {
    return username -> {
        MyUser myUser = this.myUserRespository.findByUsername(username);
        return new MyUserDetails(myUser);
    };
}