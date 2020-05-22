@Autowired
public void setCurrentUser(User currentUser) {

@Bean
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public User getUserDetails() {