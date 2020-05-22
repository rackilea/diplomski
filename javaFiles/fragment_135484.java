RequestMatcher myMatcher = AntPathRequestMatcher("/api/**");
...


@Override
void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) {

   if (myMatcher.matches(request)) {
       ...
   } else {
       ... 
   }

   chain.doFilter(request, response);
}