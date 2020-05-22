@Order(1)
@Configuration
public static class FirstConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception { /* Settings for login page 1 here. */ }
}

@Order(2)
@Configuration
public static class SecondConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception { /* Settings for login page 2 here. */ }
}

//And 3, and so on.