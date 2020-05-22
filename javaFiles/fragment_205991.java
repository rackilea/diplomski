@Service
public class Myservice(){

  @Autowired
  RepositoryContainer.Container repos;

  public void service1(){
   repos.repo1.findBy...
  }
}