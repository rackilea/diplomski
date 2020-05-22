public void doTag() {
    PageContext context = (PageContext)getJspContext();
    try {
        // The second parameter below (true) causes the JspWriter to be flushed
        context.include("/views/tags/loginBlock.jsp", true);
    } catch (Exception e) { throw new RuntimeException(e); }
}