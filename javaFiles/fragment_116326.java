@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test1 {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void test1() {
        assertNotNull(messageSource);
        assertEquals("test greg de", messageSource.getMessage("pdf.klasse", null, Locale.GERMANY));
    }
}