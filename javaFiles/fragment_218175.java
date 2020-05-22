@Configuration
public class StepWithTx {

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step step() throws Exception {
        return steps
                .get("CustomTxStep")
                .<String, String>chunk(10)
                .transactionAttribute(transactionAttribute...)
                .reader(reader...)
                .processor(processor...)
                .writer(writer...)
                .build();
    }
}