@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-app-ctx.xml")
public class FooTest {

    @Autowired
    TestTarget sut;

    @Autowired
    Foo mockFoo;

    @Test
    public void someTest() {
         // ....
    }
}