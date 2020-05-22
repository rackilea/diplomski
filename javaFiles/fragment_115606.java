@Service
public class TestService {

   @Autowired
   private ConfigDao configDao;

   private static final Logger logger = LoggerFactory.getLogger("test");

   @Transactional
   public void addJob() {
      Job job = configDao.findAll().get(0);
      logger.info("Adding job {}", job);
   }
   ...
}

@Service
public class Tests {
   @Autowired
   private TestService service;

   @EventListener(ApplicationReadyEvent.class)
   public void testJobAdd() {
      Job job = new Job();
      job.setConfig();
      service.addJob(job);
   }
}