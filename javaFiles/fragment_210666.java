@Singleton
@Lock(LockType.WRITE) // WRITE is default, but here for emphasis
public class SingletonBean {

    @Resource
    private SessionContext sessionContext;

    @Schedule(second="*/3", minute="*", hour="*")
    public void test_automatic_timer() throws InterruptedException {
        System.out.println("test_automatic_timer()");
        sessionContext.getBusinessObject(StatelessSessionBean.class).test();
    }

    @Transactional(REQUIRES_NEW)
    public void test() {
        System.out.println("test()");
    }

}