@RunWith(MockitoJUnitRunner.class)
public class MemberTest {
    @InjectMocks
    private Member member;
    @Mock
    private MemberDao memberDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createId() throws Exception {
        MembersIdDto dto = new MembersIdDto();
        dto.setId("967405286");
        when(memberDao.findNext()).thenReturn(dto);

        assertThat(member.createNewId()).isEqualTo("967405286");
    }
}