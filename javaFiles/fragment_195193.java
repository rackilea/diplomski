@Configuration
public class ReportConfig {  

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public ReportDao reportDao(){
        final ReportDaoImpl reportDao = new ReportDaoImpl();
        reportDao.setSessionFactory(sessionFactory);
        return reportDao; 
    }
}