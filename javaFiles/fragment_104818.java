@Service
    public class RandomService{
       @Autowired
       @Qualifier("hibernateRepo")
       private Repo repoClass;
    }