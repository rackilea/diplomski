@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TaskConfig.class)
public class TaskTest extends TestCase {

    @Autowired
    private Task task;

    @Test
    public void testTaskShouldNotBeNull() {
        assertNotNull(task);
    }

    @Test
    public void testTaskTitle() {
        assertNotNull(task.getTitle());
    }
}