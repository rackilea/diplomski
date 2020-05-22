public class FacesClientServlet extends javax.servlet.http.HttpServlet
        implements javax.servlet.Servlet {

    static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elContext = context.getELContext();
        ExpressionFactory expressionFactory = context.getApplication()
                .getExpressionFactory();
        ValueExpression expression = expressionFactory.createValueExpression(
                elContext, "#{myBean.text}", Object.class);
        Object value = expression.getValue(elContext);

        ResponseWriter writer = context.getResponseWriter();
        writer.write("" + value);

    }

}