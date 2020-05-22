public class SimplestServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(9080);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/*");

        server.start();
        server.dumpStdErr();
        server.join();
    }

    public static class HelloServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            System.out.println(System.currentTimeMillis() + ": Hello from HelloServlet GET");
        }

        @Override
        protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println(System.currentTimeMillis() + ": Hello from HelloServlet PUT");

            // Perform some checks here
            if (request.getHeader("X-Key") == null)
            {
                response.setHeader("Connection", "close");
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                System.out.println(System.currentTimeMillis() + ": Filter --> X-Key failed!");
                return;
            }

            // Everything OK! Read the stream.
            System.out.println(System.currentTimeMillis() + ": Proceded!!");
            InputStream body = request.getInputStream();
            long bytesReadSoFar = 0;
            byte[] data = new byte[65536];
            while (true) {
                int bytesRead = body.read(data);
                if (bytesRead < 0)
                    break;
                bytesReadSoFar += bytesRead;
            }
            System.out.println(System.currentTimeMillis() + ": Finished! Read " + bytesReadSoFar + " bytes.");
            response.setHeader("Connection", "close");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}