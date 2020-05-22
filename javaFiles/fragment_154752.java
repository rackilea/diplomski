@Autowired
    private EntityManagerFactory emf;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
        interceptor.setEntityManagerFactory(emf);
        registry.addWebRequestInterceptor(interceptor);
    }