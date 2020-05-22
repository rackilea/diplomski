public class ReportSintesiServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        Lookup<IReportGeneration> l = new Lookup<IReportGeneration>(true, IReportGeneration.class);
        IReportGeneration g = null;
        try {
            g = l.lookup();
        } catch (Exception ex) {
            return;
        }
        if (g != null) {
            String param = request.getParameter("idc");
            System.out.println("genero il report per idc " + param);
            Integer idc = Integer.parseInt(param);
            byte[] doc = (byte[]) g.generaSintesiAccordoIniziale(idc);
            if (doc != null) {
                FilePathManager fpm = new FilePathManager();
                String pathtofile = fpm.pathToNuovaSintesi(idc);
                File temp = new File(pathtofile);
                FileUtil.writeBytesToFile(temp, doc);
                response.addHeader("Content-Disposition", "attachment; filename=" + temp.getName());
                response.setContentLength((int) temp.length());
                FileInputStream fileInputStream = new FileInputStream(temp);
                OutputStream responseOutputStream = response.getOutputStream();
                int bytes;
                while ((bytes = fileInputStream.read()) != -1) {
                    responseOutputStream.write(bytes);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}