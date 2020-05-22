@Component
public class SchemaExportListener extends AbstractEnvironment implements ApplicationListener<ContextRefreshedEvent> {

@Autowired
private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

       log.debug("onApplicationEvent");

       if (isPrintSchemaEnabled()) {
          log.info("printing schema");

          SchemaExport schema = new SchemaExport(localSessionFactoryBean.getConfiguration());
          schema.setDelimiter(BaseConstants.SEMI_COLON);