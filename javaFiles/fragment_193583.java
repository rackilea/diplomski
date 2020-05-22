@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    BeerRepository beerRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege userReadPrivilege = createPrivilegeIfNotFound("USER_READ_PRIVILEGE");
        final Privilege userWritePrivilege = createPrivilegeIfNotFound("USER_WRITE_PRIVILEGE");
        final Privilege beerReadPrivilege = createPrivilegeIfNotFound("BEER_READ_PRIVILEGE");
        final Privilege beerWritePrivilege = createPrivilegeIfNotFound("BEER_WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<Privilege>(Arrays.asList(beerReadPrivilege, beerWritePrivilege, userReadPrivilege, userWritePrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<Privilege>(Arrays.asList(beerReadPrivilege, beerWritePrivilege));
        final Authority adminAuthority = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        createUserIfNotFound("rdurden",
                "rdurden@example.com",
                "Rupert",
                "Durden",
                "ILikeBeer2!",
                new ArrayList<Authority>(Arrays.asList(adminAuthority)));

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Authority createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Authority authority = roleRepository.findByName(name);
        if (authority == null) {
            authority = new Authority(name);
        }
        authority.setPrivileges(privileges);
        authority = roleRepository.save(authority);
        return authority;
    }

    @Transactional
    User createUserIfNotFound(final String username, final String email, final String firstName, final String lastName, final String password, final Collection<Authority> authorities) {
        User user = Optional.ofNullable(userRepository.findByEmail(email)).orElseGet(() -> userRepository.findByUsername(username));

        if (user != null) return user;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date lastMonthDate = cal.getTime();
        Timestamp lastMonthTimestamp = new Timestamp(lastMonthDate.getTime());

        user = new UserBuilder()
                .bAuthorities(authorities)
                .bUsername(username)
                .bFirstName(firstName)
                .bLastName(lastName)
                .bEmail(email)
                .bPassword(passwordEncoder.encode(password))
                .bIsUsing2FA(false)
                .bEnabled(true)
                .bLastPasswordResetDate(lastMonthTimestamp)
                .createUser();

        user = userRepository.save(user);
        return user;
    }
}