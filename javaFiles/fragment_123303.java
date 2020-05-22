import static org.mockito.Mockito.*;

public class CorrectionServiceTest {

    @Before
    public void setUp() {
        addressDao = mock(AddressDao.class);
        correctionService = new CorrectionService(addressDao);
    }


    @Test
    public void shouldCallDeleteAddress() {
        correctionService.correct(VALID_ID);
        verify(addressDao).deleteAddress(VALID_ID);
    }
}