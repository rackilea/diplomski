@Component
public class LCBOStoreWriter implements ItemWriter<LCBOStore> {

    @Autowired
    private DatabaseConfig dbConfig;

    @Override
    public void write(List<? extends LCBOStore> items) throws Exception {

        JpaItemWriter wr = new JpaItemWriter();

        wr.setEntityManagerFactory(dbConfig.entityManagerFactory());
        wr.write(items);

    }
}