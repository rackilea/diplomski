public interface SiteRepository extends PagingAndSortingRepository<Site, String>{
    List<Site> findByStatus(Site.Status status);
}

@Service
public class CachedSiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Cacheable("sites")
    List<Site> findByStatus(Site.Status status) {
        return siteRepository.findByStatus(status);
    }

}