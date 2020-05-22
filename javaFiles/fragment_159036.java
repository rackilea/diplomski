public class TestTaglib extends TagSupport {


 private String  testCode;
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            //doing some conversion with testCode
            String value = (String) ExpressionUtil.evalNotNull("test", "testCode", testCode, String.class, this, pageContext);
            out.print(value);
            return EVAL_PAGE;
        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }
    }
}