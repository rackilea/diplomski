@Autowired
  private SecurityCheck securityCheck;

  ................

  @Override
  @PreAuthorize("@securityCheck.check(#user,authentication)")
  void delete(User user);