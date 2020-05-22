public void write(PageContext pageContext, String text)
        throws JspException {

    JspWriter writer = pageContext.getOut();

    try {
        writer.print(text);

    } catch (IOException e) {
        throw new JspException(e);
    }

}