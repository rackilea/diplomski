@Autowired 
private AutowireCapableBeanFactory beanFactory;

@PostConstruct
public void job1() {
    NewDataCollectionThread thread1 = new NewDataCollectionThread();
    beanFactory.autowireBean(thread1);
    job1 = threadPoolTaskScheduler.scheduleAtFixedRate(thread1, 1000);
}