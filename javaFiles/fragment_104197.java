@Autowired
private BCryptPasswordEncoder encoder;

public void createUser(User user){
    user.setPassword(encoder.encode("passwordStringHere");
    .
    .
    .
}