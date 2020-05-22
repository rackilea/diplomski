/**
 * Test FooController
 */
public class FooControllerTest {

    @Mock
    private FooService fooService;

    @InjectMocks
    private FooController fooController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(fooController).build();
    }

    @Test
    public void testAdd() throws Exception {

        Foo foo = new Foo();

        // given
        given(FooService.createFoo()).willReturn(foo);

        // when
        // then
        this.mockMvc.perform(get("/foo/new"))
            .andExpect(forwardedUrl("foo/detail"))
            .andExpect(model().attributeExists("foo"))
            .andExpect(model().attribute("foo", is(foo)));
    }

    @Test
    public void testDetail() throws Exception {

        Foo foo = new Foo();
        Long fooId = 1L;

        // given
        given(fooService.findById(fooId)).willReturn(foo);

        // when
        // then
        this.mockMvc.perform(get("/foo/" + fooId))
            .andExpect(forwardedUrl("foo/detail"))
            .andExpect(view().name("foo/detail"))
            .andExpect(model().attributeExists("foo"))
            .andExpect(model().attribute("foo", is(foo)));
    }

    @Test
    public void testSave() throws Exception {

        Foo foo = new Foo();

        // given
        // when
        // then

        //With form errors
        this.mockMvc.perform(post("/foo/update")
                .param("name", "")
                .sessionAttr("foo", foo))
        .andExpect(forwardedUrl("foo/detail"))
        .andExpect(model().hasErrors())
        .andExpect(model().attributeHasFieldErrors("foo", "name"));

        //Without form errores
        this.mockMvc.perform(post("/foo/update")
                .param("name", "nameValue")
                .param("code", "codeValue")
                .param("date", "20/10/2015")
                .requestAttr("referer", "/foo/list")
                .sessionAttr("foo", foo))
        .andExpect(view().name("redirect:" + "/foo/list"))
        .andExpect(model().hasNoErrors())
        .andExpect(flash().attributeExists("message"))
        .andExpect(flash().attribute("message", hasProperty("message", is("message.ok"))))
        .andExpect(flash().attribute("message", hasProperty("type", is(Message.Type.SUCCESS))))
        .andExpect(status().isFound());
    }

    @Test
    public void testDelete() throws Exception {
        Foo foo = new Foo();
        foo.setOtherFoos(new ArrayList<OtherFoo>());
        Long fooId = 1L;

        // given
        given(fooService.findByIdWithOtherFoos(fooId)).willReturn(foo);

        // when
        // then
        //Without errors: without other foos
        this.mockMvc.perform(post("/foo/delete/" + fooId)
                .sessionAttr("foo", foo)
                .requestAttr("referer", "/foo/list"))
        .andExpect(view().name("redirect:" + "/foo/list"))
        .andExpect(flash().attributeExists("message"))
        .andExpect(flash().attribute("message", hasProperty("message", is("message.ok"))))
        .andExpect(flash().attribute("message", hasProperty("type", is(Message.Type.SUCCESS))));


        // given
        foo.getOtherFoos().add(new OtherFoo());
        given(fooService.findByIdWithOtherFoos(fooId)).willReturn(foo);

        // when
        // then
        //With errors: with other foos
        this.mockMvc.perform(post("/foo/delete/" + fooId)
                .sessionAttr("foo", foo)
                .requestAttr("referer", "/foo/list"))
        .andExpect(view().name("redirect:" + "/foo/list"))
        .andExpect(flash().attributeExists("message"))
        .andExpect(flash().attribute("message", hasProperty("message", is("message.error"))))
        .andExpect(flash().attribute("message", hasProperty("type", is(Message.Type.DANGER))));
    }

}