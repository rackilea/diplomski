@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "test-context.xml"})
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class SampleCrudTest {

    @Autowired
    private SampleCrud sampleCrud;

    @Before 
    public void onSetUpInTransaction() throws Exception {
        //Populate Test Data
    }


    @Test
    public void registerSample() {

        Sample sample = new Sample("foo");
        sampleCrud.save(sample);
        assertNotNull(sample.getId());
    }

}