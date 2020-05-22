@Bean
  public Function<UserDetails, User> fetchUser() {
    return (principal -> {
      String name = principal.getUsername()
      //do JPA logic
      return ...
    });
  }