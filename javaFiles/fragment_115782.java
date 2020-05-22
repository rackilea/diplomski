else if (operation.equals("delete")) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/delete.jsp");
    dispatcher.forward(request, response);

} else if (operation.equals("deletepage")) {
    PageData pageData = new PageData();
    pageData.setId(request.getParameter("id"));
    dao.deletePage(pageData);
    response.sendRedirect("adminController");
}