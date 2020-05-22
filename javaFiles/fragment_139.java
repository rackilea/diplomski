class Delegator {

    @Autowired
    private BeanFactory bf;

    public MyService findService(String action) {
        return BeanFactoryAnnotationUtils.qualifiedBeanOfType(bf, MyService.class, action);
    }

}

@Service
@Qualifier("foo")
public MyService1 implements MyService { ... }

@Service
@Qualifier("bar")
public MyService2 implements MyService { ... }