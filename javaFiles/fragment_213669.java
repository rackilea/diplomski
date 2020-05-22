package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

    private void test(JspWriter out, String msg) throws java.io.IOException {
        out.println(msg);
    }

    /* ...lots of setup stuff omitted... */

    public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        JspWriter _jspx_out = null;
        PageContext _jspx_page_context = null;


        try {
            response.setContentType("text/html");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                        null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;

            out.write("<!doctype html>\n");
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("<meta charset=\"utf-8\">\n");
            out.write("<title>Example</title>\n");
            out.write("</head>\n");
            out.write("<body>\n");

            out.println("The current date/time is " + new java.util.Date());
            this.test(out, "Hi, Mom!");

            out.write("\n");
            out.write("</body>\n");
            out.write("</html>\n");
        } catch (Throwable t) {
            if (!(t instanceof SkipPageException)){
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    try { out.clearBuffer(); } catch (java.io.IOException e) {}
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
                else log(t.getMessage(), t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }
}