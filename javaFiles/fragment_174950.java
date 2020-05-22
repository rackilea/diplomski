@RunWith(SpringRunner.class)
@DataJpaTest
public class FooRepositoryTest {

    @Autowired
    private FooRepository fooRepo;

    @Test
    public void notNull(){
        assertNotNull(fooRepo);
    }
}