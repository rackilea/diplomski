class UserHandshakeRepositoryIntegrationTest extends AbstractJpaTest {

@Autowired UserHandshakeRepoImpl handshakeRepository;    


@Test
public void testSave() {
    UserHandshake handshake = handshakeRepository.save(new UserHandshake());
    assertThat(handshake.getId(), is(notNullValue()));
}