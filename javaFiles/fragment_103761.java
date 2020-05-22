@Service
public class A implements ApplicationContextAware {

    private static final AtomicReference<A> singleton;
    private static final CountDownLatch latch = new CountDownLatch(1);

    @Resource
    private MyInjectedBean myBean; // inject stuff...

    public static A getInstance() {
        try {
            if (latch.await(1, TimeUnit.MINUTES)) {
                return singleton.get();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new IllegalStateException("Application Context not initialized");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        singleton.set(context.getBean(A.class));
        latch.countDown();
    }
}