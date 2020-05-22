@Singleton
public class IndexController extends HttpServlet {

    @Inject ListService listService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("names", listService.names());
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

}