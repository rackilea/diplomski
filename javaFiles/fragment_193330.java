@Override
protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
         .antMatchers("/","/home").permitAll()
         .antMatchers("/admin/**").access("hasRole('ADMIN')")
         // more lines 
}