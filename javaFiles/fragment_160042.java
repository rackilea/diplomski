public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberDAO dao = DAOFactory.getMemberDAO();
        List<Member> members = dao.getMembers();
        request.setAttribute("members", members);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/members.jsp");
        rd.forward(request, response);
    }
}