@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = {YourBeans.class, MoreOfYourBeans.class})
public class UserRepoTest {

  @Autowired
  private UserRepo userRepo = null;

  @Autowired
  private TestEntityManager entityManager = null;