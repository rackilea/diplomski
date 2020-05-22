@Autowired
private Environment env;

@PostUpdate
public void methodInvoked afterUpdate(Example example) {
  SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
  String[] activeProfile = env.getActiveProfiles();

}