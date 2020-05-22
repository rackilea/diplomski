RequestMatcher customRequestMatcher = new AndRequestMatcher(
      new AntPathRequestMatcher("/v1/**"), 
      new NegatedRequestMatcher(
          new AntPathRequestMatcher("/v1/users", "POST")
      ),
      new NegatedRequestMatcher(
          new AntPathRequestMatcher("/v1/users/signin", "POST")
      )
 );