class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final PasswordEncoder passwordEncoder;
    private final Neo4jOperations template;

    @Autowired
    public PersonRepositoryImpl(PasswordEncoder passwordEncoder,
                                SaltSource saltSource
                                Neo4jOperations template) {

        this.passwordEncoder = passwordEncoder;
        this.saltSource = saltSource;
        this.template = template;
    }

    @Override
    @Transactional
    public void persist(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword(), saltSource));
        template.save(person);
    }
}