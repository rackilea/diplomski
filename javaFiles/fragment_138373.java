@Service
public class CompanyServiceImpl implements CompanyService, BeanNameAware {

private String name;

  private CompanyService proxy;

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void setBeanName(String name) {
    this.name = name;
  }

@PostConstruct
  public void postConstruct() {
    proxy = (CompanyService)applicationContext.getBean(name);
    proxy.refreshStopJobs();
  }

@Transactional(readOnly = true)
    @Override
    public void refreshStopJobs() {
        companyDao.getCompanysByStatus(CampaignStatus.START).forEach(this::refreshStopJob);
    }

}