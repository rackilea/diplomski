@Configuration
@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Controller
    public class HomeController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String home(Model model, Authentication authentication, Principal principal) {
            if (authentication == null) {
                return "forward:/login";
            } else {
                model.addAttribute("user", principal.getName());
                return "home";
            }
        }
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfig() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable().authorizeRequests()
                        .anyRequest().authenticated()
                        .and().formLogin().loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                        .and().logout().permitAll();
                http.headers().frameOptions().disable();
            }

            @Override
            protected void configure(AuthenticationManagerBuilder builder) throws Exception {
                builder.authenticationProvider(new AuthenticationProvider() {
                    @Override
                    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                        String username = authentication.getName();
                        String password = authentication.getCredentials().toString();
                        if (username.equals("username") && password.equals("password")) {
                            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                            return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
                        }
                        throw new AuthenticationServiceException("Invalid credentials.");
                    }

                    @Override
                    public boolean supports(Class<?> authentication) {
                        return authentication.equals(UsernamePasswordAuthenticationToken.class);
                    }
                });
            }
        };
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }
}