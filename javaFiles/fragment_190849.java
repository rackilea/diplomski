@Transactional
@RunWith(Parameterized.class)
@ContextConfiguration(classes={RootApplicationContext.class})
//@ActiveProfiles() ... disable
@TestExecutionListeners(listeners={LoggingTestExecutionListener.class}, mergeMode=MergeMode.MERGE_WITH_DEFAULTS)
public abstract class PersonaServiceImplTest {

   ...

   @Autowired
   private Environment environment;

   @Before
   public void setup(){
    logger.info("Profiles: {}", Arrays.toString(environment.getActiveProfiles()));
   }

   //@Test disable
   public void someTest(){

     assertThat(...)

   }

    @ActiveProfiles(resolver=TestJdbcActiveProfilesResolver.class)
    public static class ForJdbc extends PersonaServiceImplTest {

        public ForJdbc(Persona persona){
            super(persona);
        }

        @Test
        @Override
        @Sql(scripts={"classpath:/.../script.sql"})//when be necessary
        public void someTest()(){
            super.someTest()();
        }

      }

    @ActiveProfiles(resolver=TestHibernateActiveProfilesResolver.class)
    public static class ForHibernate extends PersonaServiceImplTest {

        public ForHibernate(Persona persona){
            super(persona);
        }

        @Test
        @Override
        @Sql(scripts={"classpath:/.../script.sql"})//when be necessary
        public void someTest()(){
            super.someTest()();
        }

        ...

      }

   }