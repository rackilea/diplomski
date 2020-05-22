@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class MyRepositoryTest {
   ...
}