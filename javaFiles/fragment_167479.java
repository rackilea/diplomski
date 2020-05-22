@Service
public class CompanyService {

    @Autowired
    private ApplicationContext applicationContext;

    public void useCompanySpecificMessageSource(Company c) {
        MessageSource ms = applicationContext.getBean(c.getSlug() + "_messageSource");
        log.debug(ms.getMessage("code", null, new Locale("en", "GB"));
    }
}