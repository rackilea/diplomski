@Before
public void setUp() {
    Session.current.set(new Session());
    Request.current.set(new Request());
    Response.current.set(new Response());
}