@Bean
@Override
public UserDetailsService userDetailsService() {
    UserDetails user =
            User.withDefaultPasswordEncoder()
                    .username("u")
                    .password("p")
                    .roles("USER")
                    .build();

    return new InMemoryUserDetailsManager(user);
}