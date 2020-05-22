else if (operation.equals("delete")) {
    PageData pageData = new PageData();
    pageData.setId(request.getParameter("id"));
    dao.deletePage(pageData);
    response.sendRedirect("adminController");
}