@RunWith(SpringRunner.class)
@DataJpaTest
public class ImageProposalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ImageProposalRepository imageProposalRepository;

    @Test
    public void testFindOne() throws Exception {
        ImageProposal imageProposal = ImageProposal.builder()
                .size(1024)
                .filePath("/test/file/path").build();
        entityManager.persist(imageProposal);
        ImageProposal foundImageProposal = imageProposalRepository.findOne(imageProposal.getId());
        assertThat(foundImageProposal).isEqualTo(imageProposal);
    }
}