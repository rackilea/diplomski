public void configure(HttpSecurity http){
    .....

    web.ignoring().requestMatchers(new MethodTypeRequestMatcher(RequestMethod.GET));

   .....

}