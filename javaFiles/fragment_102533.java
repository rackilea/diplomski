@Configuration
public class SchedulerConfig 
{
    private DataSource dataSource;

    private PlatformTransactionManager transactionManager;

    @Autowired
    public SchedulerConfig(@Qualifier("schedulerDataSource") DataSource dataSource, @Qualifier("schedulerTransactionManager") PlatformTransactionManager transactionManager) 
    {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Bean
    public SchedulerFactoryBeanCustomizer schedulerFactoryBeanCustomizer() 
    {
        return bean -> 
        {
            bean.setDataSource(dataSource);
            bean.setTransactionManager(transactionManager);
        };
    }
}