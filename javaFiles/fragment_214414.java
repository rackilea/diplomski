public class RefCacheTest extends AbstractTest {

    @Autowired
    private RefSituationService refSituationService;

    @Autowired
    private RefCivilityService refCivilityService;

    @Autowired
    private CacheManager cacheManager;


    @Test
    public void findById() {

        Cache refCache = cacheManager.getCache(MyCache.REFS);
        refCache.setStatisticsEnabled(true);

        assertThat(refSituationService.findById(1L)).isInstanceOf(RefSituation.class);
        assertThat(refSituationService.findById(1L)).isInstanceOf(RefSituation.class);
        assertThat(refSituationService.findById(2L)).isInstanceOf(RefSituation.class);

        assertThat(refCivilityService.findById(1L)).isInstanceOf(RefCivility.class);
        assertThat(refCivilityService.findById(1L)).isInstanceOf(RefCivility.class);
        assertThat(refCivilityService.findById(2L)).isInstanceOf(RefCivility.class);

        System.out.println(refCache.getName() +" - "+ refCache.getStatistics().toString()); 

        assertThat(refCache.getStatistics().getCacheHits()).isEqualTo(2);
        assertThat(refCache.getSize()).isEqualTo(4);
    }