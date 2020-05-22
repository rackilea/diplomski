@Stateless
public class ContextProviderBean {

    @Resource
    private SessionContext sctx;

    public void setSctx(SessionContext sctx) {
        this.sctx = sctx;
    }

    public SessionContext getSctx() {
        return sctx;
    }

}