@Configuration
public class FooServiceImplTestConfiguration {

    @Bean
    public FooService fooService() {
        return new FooServiceImpl();
    }

    @Bean
    public FooRepository fooRepository() {
        return Mockito.mock(FooRepository.class);
    }
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FooServiceImplTestConfiguration.class})
public class FooServiceImplTest {

    @Inject
    private FooRepository fooRepository;;

    @Inject
    private FooService fooService;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createFoo() {
        assertNotNull(fooService.createFoo());
    }

    @Test
    public void save() {

        //New foo
        Foo saveFoo = new Foo();
        // given

        // when
        fooService.save(saveFoo);

        // then
        assertNotNull(saveFoo.getDate());

        saveFoo.setId(1L);
        Date date = new Date();
        saveFoo.setDate(date);

        // given

        //when
        fooService.save(saveFoo);

        //then
        assertThat(date, is(saveFoo.getDate()));
    }

    @Test
    public void delete() {

        //given

        //when
        fooService.deleteFoo(Matchers.anyLong());

        //then
    }

    @Test
    public void findById() {
        Long id = 1L;
        Foo fooResult = new Foo();

        //given
        given(fooRepository.findOne(id)).willReturn(fooResult);

        //when
        Foo foo = fooService.findById(id);

        //then
        assertThat(foo, is(fooResult));
    }

    @Test
    public void findByIdWithOtherFoos() {
        Long id = 1L;
        Foo fooResult = new Foo();

        //given
        given(fooRepository.findOne(id)).willReturn(fooResult);

        //when
        Foo foo = fooService.findByIdWithOtherFoos(id);

        //then
        assertThat(foo, is(fooResult));
    }

    @Test
    public void findAll() {
        Page<Foo> fooResult = new PageImpl<>(new ArrayList<Foo>());

        given(fooRepository.findAll(Matchers.<Pageable>anyObject())).willReturn(fooResult);

        //when
        Page<Foo> foos = fooService.findAll(Matchers.<Pageable>anyObject());

        //then
        assertThat(foos, is(fooResult));
    }

    @Test
    public void findAllList() {
        List<Foo> fooResult = new ArrayList<Foo>();

        given(fooRepository.findAll(Matchers.<Sort>anyObject())).willReturn(fooResult);

        //when
        List<Foo> foos = fooService.findAll(Matchers.<Sort>anyObject());

        //then
        assertThat(foos, is(fooResult));
    }
}