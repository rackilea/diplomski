String page = "";
    try {

    } catch (Exception e) {
      page = "error.jsp";
    } finally {
      page = "usertaskpage.jsp";
    }

RequestDispatcher dd=request.getRequestDispatcher(page);
dd.forward(request, response);