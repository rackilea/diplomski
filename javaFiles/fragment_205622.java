@Autowired
private UserDetailsManager users;
@Autowired
private PasswordEncoder enc;

@RequestMapping(...)
public String handle(Model model) {
    users.createUser(new User(username, enc.encode(password), authorities);

    return "view";
}