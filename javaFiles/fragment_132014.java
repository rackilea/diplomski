@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(new MyUserDetailsService(this.mongoTemplate))
        .passwordEncoder(new ShaPasswordEncoder(256));
}