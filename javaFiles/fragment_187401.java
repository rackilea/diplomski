public class MyTest {
  @Mock private MyService mock;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void nam3e() {
    ArrayList<Listener> listeners = new ArrayList<>();

    doAnswer(
            invocation -> {
              Object[] args = invocation.getArguments();
              Listener arg = (Listener) args[0];

              listeners.add(arg);

              return null;
            })
        .when(mock)
        .addListener(any());

    Observable<String> stringObservable =
        Observable.create(
            e -> {
              Listener listener =
                  s -> {
                    e.onNext(s);
                  };

              mock.addListener(listener);

              e.setCancellable(
                  () -> {
                    mock.removeListener(listener);
                  });
            });

    TestObserver<String> test = stringObservable.test();

    Listener listener = listeners.get(0);
    listener.onNext("Wurst");

    test.assertNotComplete().assertValue("Wurst");
    verify(mock, times(1)).addListener(any());

    test.dispose();

    verify(mock, times(1)).removeListener(any());
  }

  public interface MyService {
    void addListener(Listener listener);

    void removeListener(Listener listener);
  }

  @FunctionalInterface
  public interface Listener {
    void onNext(String s);
  }
}