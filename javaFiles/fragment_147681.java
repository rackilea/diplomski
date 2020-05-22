@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguraitonTest.class, HibernateJpaAutoConfiguration.class})
public class ItemRepositoryTest {

    @Autowired DataSource dataSource;
    @Autowired ItemRepository itemRepository;

    private final static DbSetupTracker dbSetupTracker = new DbSetupTracker();
    public static final Operation INSERT_REFERENCE_DATA = sequenceOf(
            insertInto("PODCAST")
                    .columns("ID", "TITLE", "URL", "TYPE", "HAS_TO_BE_DELETED")
                    .values(1, "AppLoad", null, "RSS", false)
                    .values(2, "Geek Inc HD", "http://fake.url.com/rss", "YOUTUBE", true)
                    .build(),
            insertInto("ITEM")
                    .columns("ID", "TITLE", "URL", "PODCAST_ID", "STATUS", "PUBDATE", "DOWNLOADDDATE")
                    .values(1L, "Appload 1", "http://fakeurl.com/appload.1.mp3", 1, Status.FINISH, now().minusDays(15).format(formatter), now().minusDays(15).format(formatter))
                    .values(2L, "Appload 2", "http://fakeurl.com/appload.2.mp3", 1, null, now().minusDays(30).format(formatter), null)
                    .values(3L, "Appload 3", "http://fakeurl.com/appload.3.mp3", 1, Status.NOT_DOWNLOADED, now().format(formatter), null)
                    .values(4L, "Geek INC 123", "http://fakeurl.com/geekinc.123.mp3", 2, Status.DELETED, now().minusYears(1).format(formatter), now().format(formatter))
                    .values(5L, "Geek INC 124", "http://fakeurl.com/geekinc.124.mp3", 2, Status.FINISH, now().minusDays(15).format(formatter), now().minusDays(15).format(formatter))
                    .build(),
            insertInto("TAG")
                    .columns("ID", "NAME")
                    .values(1L, "French Spin")
                    .values(2L, "Studio Knowhere")
                    .build(),
            insertInto("PODCAST_TAG")
                    .columns("PODCAST_ID", "TAG_ID")
                    .values(1, 1)
                    .values(2, 2)
                    .build()
    );

    @Before
    public void prepare() throws Exception {
        Operation operation = sequenceOf(DELETE_ALL, INSERT_REFERENCE_DATA);
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);

        dbSetupTracker.launchIfNecessary(dbSetup);
    }

    @Test
    public void should_find_by_podcast_and_page() {
        /* Given */
        dbSetupTracker.skipNextLaunch();
        Integer podcastId = 1;
        PageRequest pageRequest = new PageRequest(1, 1, Sort.Direction.ASC, "id");

        /* When */
        Page<Item> itemByPodcast = itemRepository.findByPodcast(podcastId, pageRequest);

        /* Then */
        PageAssert
                .assertThat(itemByPodcast)
                .hasSize(1)
                .hasTotalElements(3)
                .hasTotalPages(3)
                .hasNumberOfElements(1);

        ItemAssert
                .assertThat(itemByPodcast.getContent().get(0))
                .hasTitle("Appload 2");
    }