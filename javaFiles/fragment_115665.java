public class OrganizationServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String organizatio = request.getParameter("orgName");

            if (organizatio.equals("ABC")) {
                printAllOrganization(request);

            }
        }

        public void printAllOrganization(HttpServletRequest request) {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html");

            pw.println("<!DOCTYPE html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n");
            pw.println("<html>\n");
            pw.println("<head>\n");
            pw.println("<title> Print Organization </title>\n");
            pw.println("<link rel=\"stylesheet\" type=\"text/css\" HREF=\"" + request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/resource/styles/myStyle.css\">\n");
            pw.println("</head>\n");

            pw.println("<body>\n");

            //printing all organization code is here!
            pw.println("</body>\n");

            pw.println("</html>\n");
            pw.close();
        }