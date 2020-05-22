public class doSomething {
    public void caricaFile(HttpServletRequest request, HttpServletResponse response, FiltriParameters filtri) throws IOException 
    {
        RetObj r = caricaFile(request, response, filtri, ...);
        response.setContentType("text/json");
        response.getWriter().println(Utils.json(r));
    }
}