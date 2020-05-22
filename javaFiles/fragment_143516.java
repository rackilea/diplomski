@RunWith(MockitoJUnitRunner.class)
public class BookingServicesTests {

    private MockMvc mvc;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingResource bookingController;
    ...
}