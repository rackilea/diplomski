@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.jpa.hibernate.ddl-auto="})
@DataJpaTest
@Sql(<my sql files>)
public class MyRepoTest{
   @Autowired
   private EntityManager em;

   private myRepo repo;

   @Before
   public void setUp(){
      try{
         Field f1 = repo.getClass().getDeclaredField("em");
         f1.setAccessible(true);
         f1.set(repo, em);
      }
      catch(Exception e){}
   }

   @Test
   public void doMyTest(){
      repo.findMyObjects()
   }
}