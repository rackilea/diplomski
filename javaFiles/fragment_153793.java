@Service
public class OtherBean {
    @Autowired
    private YourService yourService;    

    // note that no transactional annotation is used, this is intentional
    public otherMethod() {
        yourService.createImages(); // first transaction - images are committed

        yourService.addImagesToArticle(); // second transaction - images are added to article
    }
}