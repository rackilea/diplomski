public class ContextServlet extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private FacesContextFactory facesContextFactory;
    private Lifecycle lifecycle;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
                .getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        facesContextFactory = (FacesContextFactory) FactoryFinder
                .getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        lifecycle = lifecycleFactory
                .getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        FacesContext context = facesContextFactory.getFacesContext(
                getServletContext(), request, response, lifecycle);
        try {
            ELContext elContext = context.getELContext();
            ExpressionFactory expressionFactory = context.getApplication()
                    .getExpressionFactory();
            ValueExpression expression = expressionFactory
                    .createValueExpression(elContext, "#{myBean.text}",
                            Object.class);
            Object value = expression.getValue(elContext);

            PrintWriter pw = response.getWriter();
            try {
                pw.write("" + value);
            } finally {
                pw.close();
            }
        } finally {
            context.release();
        }
    }

}