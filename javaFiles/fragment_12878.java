@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "mail.adapter")
public class ClientAdapterConfig {

    @Qualifier("mailClientA")
    @Autowired
    private ClientAdapter mailClientA;

    @Qualifier("mailClientB")
    @Autowired
    private ClientAdapter mailClientB;

    private String name;

    @Bean
    @Primary
    public ClientAdapter getAdapter()
    {
        ClientAdapter adapter = null;
        switch (name) {
            case "mailClientA":
                adapter = mailClientA;
                break;
            case "mailClientB":
                adapter = mailClientB;
                break;
            default:
                break;
        }

        return adapter;
    }
}