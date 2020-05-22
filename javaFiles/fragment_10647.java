public class IterableForEachTag extends BodyTagSupport {
    private static final long serialVersionUID = 1L;
    private Iterable<?> iterable = null;
    private Iterator<?> iterator = null;
    private String var = null;

    public int doStartTag() throws JspException {
        if (iterator == null) {
            iterator = iterable.iterator();
        }
        if (iterator.hasNext()) {
            Object element = iterator.next();
            pageContext.setAttribute(var, element);
            return (EVAL_BODY_AGAIN);
        } else
            return (SKIP_BODY);
    }

    public int doAfterBody() throws JspException {
        if (bodyContent != null) {
            try {
                JspWriter out = getPreviousOut();
                out.print(bodyContent.getString());
                bodyContent.clearBody();
            } catch (IOException e) {
                throw new JspException(e);
            }
        }
        if (iterator.hasNext()) {
            Object element = iterator.next();
            pageContext.setAttribute(var, element);
            return (EVAL_BODY_AGAIN);
        } else {
            return (SKIP_BODY);
        }
    }

    public void setIterable(Iterable i) {
        iterable = i;
        iterator = null;
    }

    public void setVar(String v) {
        var = v;
    }
}