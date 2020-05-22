@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"Student-servlet.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class TestDAO {

   @Autowired
   private DatabaseStudent studentDAO;

    @Test
    public void testHandler(){
        Assert.assertNotNull(studentDAO);
        Handler handler = new Handler();
        handler.setStudentDAO(studentDAO);
        Student student = new Student("Test1","Test2","Test3","Test4",4);
        handler.addStudent(student);
    }
    ...
}