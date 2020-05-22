@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {

    @InjectMocks
    ServiceImpl service

    @Spy
    @InjectMocks
    private Helper helper;

    @Mock
    private Repository repoMock;

    @InjectMocks
    private Helper helper;
}