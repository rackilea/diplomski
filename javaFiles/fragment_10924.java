private ActorSystem system;
private Materializer materializer;

@BeforeEach
public void setup() {
    system = ActorSystem.create("StreamTestKitDocTest");
    materializer = ActorMaterializer.create(system);
}

// ...

@Test
public void test() throws InterruptedException, ExecutionException, TimeoutException {
    // ...
    Source.from(Arrays.asList(1, 2, 3, 4)).runWith(sinkUnderTest, materializer);
    // ...
}