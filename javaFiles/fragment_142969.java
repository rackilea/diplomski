@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:cache.xml"})
public abstract class TestEcacheSpring {

  @Autowired
  EcacheSpringtest test;

  @Test
  public void test(){
    test.getName("test");
    test.getName("test"); 
  }

}