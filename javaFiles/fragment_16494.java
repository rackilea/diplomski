@Service
public class MyService {

    @Autowired
    private TweetpostRepository repository;

    public void trunkateTweetposts(){
        Page<Integer> page = repository.findLatestId(new PageRequest(0, 10));
        repository.deleteByExcludedId(page.getContent());
        ...
    }

}