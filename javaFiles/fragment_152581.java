@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    PlatformController.class,
    MongoTestConfig.class
})
@WebFluxTest(PlatformController.class)