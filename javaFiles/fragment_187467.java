@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "/beans-datasource-it.xml",
    "/beans-dao.xml",
    "/beans-service.xml",
    "/beans-web.xml" })
@Transactional
public class ContactControllerIT {
    @Inject private ContactController controller;

    ... setUp() and tearDown() ...

    @Test
    public void testGetContact() {
        String viewName = controller.getContact(request, 1L, model);

        ... assertions ...
    }
}