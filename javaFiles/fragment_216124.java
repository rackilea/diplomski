@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;


    @Override
    @Transactional
    public List<Url> getAllUrls() {
        return urlDao.getAllUrls();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)  // ADDED READONLY TO WORK IN NEW HIBERNATE VERSIONS
    public List<Url> getAllUrlsNoTxn() {
        return urlDao.getAllUrls();
    }

}