@SpringBootTest
@RunWith(SpringRunner.class)
public class ReferenceIdentifierTest {

    @Autowired
    private FormsDB formsDB;

    @Test
    public void testCreateTopLevelReferencesFrom() throws Exception {
        ReferenceIdentifier referenceIdentifier = new ReferenceIdentifier(formsDB);
    }
}