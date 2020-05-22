@Repository
public class RepositoryContainer(){

  public interface Myrepo1 extends JpaRepository<Entity1, Long> {
  }

  public interface Myrepo2 extends JpaRepository<Entity2, Long> {
  }
   //I am using an inner bean to get my repositories
  @Component
  public class Container{
    @Autowired
    public Myrepo1 repo1;
    @Autowired 
    public Myrepo2 repo2; 
  }
}