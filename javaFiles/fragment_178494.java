@ExtendWith(MockitoExtension.class)//for JUnit 5, but you can add the JUnit 4 annotation
public class DoseServiceTest {
    @Mock
    private DoseRepository doseRepository;

    @InjectMocks
    private DoseService sut;//System Under Test

    @Test
    public void testDeleteDose() {
        int doseId=42;

        // perform the call
        sut.deleteDose(doseId);

        // verify the mocks
        verify(doseRepository, times(1)).deleteById(eq(doseId));
    }
}