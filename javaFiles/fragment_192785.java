Server server;

@Before
public void before() throws Exception {
    server = new Server(8080);
    server.addHandler(new WebAppContext(WEB_INF_DIRECTORY, "/"));
    server.start(); 
}

@After
public void after() throws Exception {
    server.stop();
}

@Test
public void upload() {
    upload("http://localhost:8080/file", "file.txt");
}