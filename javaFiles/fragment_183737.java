class GenericService<T, T_DAO extends GenericDao<T>> {
    private final T_DAO tDao;

    GenericService(T_DAO tDao) {
        this.tDao = tDao;
    }
}

@Service
FooService extends GenericService<Foo, FooDao> {

    @Autowired
    FooService(FooDao fooDao) {
        super(fooDao);
    }
}