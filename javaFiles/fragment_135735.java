@Autowired
private CaptchaFilter captchaFilter;

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .antMatcher("/iapi/**")
            .addFilterBefore(captchaFilter, (Class<? extends Filter>) ChannelProcessingFilter.class)
            .addFilterBefore(filterA, (Class<? extends Filter>) UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .anyRequest().authenticated();
    }