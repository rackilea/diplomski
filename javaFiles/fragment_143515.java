@RunWith(SpringRunner.class)
@WebMvcTest(BookingResource.class) // multiple controller class could go here
@AutoConfigureMockMvc
public class BookingServicesTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookingRepository bookingRepository;

    ...
}