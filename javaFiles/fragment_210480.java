public class T9nDictionaryTag extends TagSupport {

    private String fieldName;
    private String objectName;

    public int doStartTag() throws JspException {
        try {
            Object object = pageContext.getRequest().getAttribute(objectName);
            Class clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);

            if (field.isAnnotationPresent(T9n.class)) {
                T9n labelLookup = field.getAnnotation(T9n.class);
                JspWriter out = pageContext.getOut();
                out.print(labelLookup.value());
            }

        } catch(IOException e) {
            throw new JspException("Error: " + e.getMessage());
        } catch (SecurityException e) {
             throw new JspException("Error: " + e.getMessage());
        } catch (NoSuchFieldException e) {
             throw new JspException("Error: " + e.getMessage());
        }       
        return EVAL_PAGE;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}