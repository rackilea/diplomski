class Facade() {
    @Inject
    Dao dao;

    List<Company> companies;

    @PostConstruct
    init() {
        companies = Dao.findByNamedQuery("Companies.ALL");
        Hibernate.initialize(companies.getPersonList()); 
    }
}