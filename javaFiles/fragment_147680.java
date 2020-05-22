@Configuration
@EnableJpaRepositories(basePackages = "lan.dk.podcastserver.repository")
@EntityScan(basePackages = "lan.dk.podcastserver.entity")
public class DatabaseConfiguraitonTest {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

    @Bean
    @Autowired
    public FullTextEntityManager fullTextEntityManager(EntityManager entityManager) {
        return getFullTextEntityManager(entityManager);
    }

    public static final DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral(" ").append(DateTimeFormatter.ISO_LOCAL_TIME).toFormatter();
    public static final Operation DELETE_ALL_PODCASTS = deleteAllFrom("PODCAST");
    public static final Operation DELETE_ALL_ITEMS = deleteAllFrom("ITEM");
    public static final Operation DELETE_ALL_TAGS = sequenceOf(deleteAllFrom("PODCAST_TAG"), deleteAllFrom("TAG"));
    public static final Operation DELETE_ALL = sequenceOf(DELETE_ALL_ITEMS, DELETE_ALL_TAGS, DELETE_ALL_PODCASTS, DELETE_ALL_TAGS);
}