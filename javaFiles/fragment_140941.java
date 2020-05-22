@WebFilter("/*")
public class DBTransactionHandler implements Filter {

    @Inject
    DBConnectionFactory connectionFactory;

    @Inject
    SessionProducer sessionProducer;

    ...

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean hadException = false;
        try {
            SessionImpl sessionImpl = new SessionImpl();
            sessionImpl.setConnectionFactory(connectionFactory);
            sessionProducer.getCurrentSessionThreadLocal().set(sessionImpl);
            // here you probably want to call sessionImpl.init();
            chain.doFilter(request, response);
        } catch (RuntimeException ex) {
            hadException = true;
            throw ex;
        } finally {
            if (sessionImpl != null) {
                if (hadException || sessionImpl.isRollbackOnly()) {
                    sessionImpl.rollback();
                } else {
                    sessionImpl.commit();
                }
                sessionImpl.close();
                sessionProducer.getCurrentSessionThreadLocal().set(null);
            }
        }
    }

    ...
}