@Service("technologiesService")
public class TechServiceImpl implements TechService {

    @Autowired
    private ProjectRepository projectRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Technologies> getAllTechnologies() {
        return entityManager.createQuery("SELECT t FROM Technologies t").getResultList();
    }
}