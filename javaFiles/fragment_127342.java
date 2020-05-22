public int doStartTag() throws JspException {
    if (pageContext.getAttribute("validated") == null) {
        // validation code writing
        pageContext.setAttribute("validated", true);
    }
    ...
}