protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    Query query = new Query();

    if (request.getParameter("sendReviewButton") != null){
        String userName = request.getParameter("reviewName");
        String eMail = request.getParameter("reviewMail");
        String reviewList = request.getParameter("reviewText");
        query.addReview(userName, eMail, reviewList);

        Object allReviews = query.getAllReviews();
        request.setAttribute("allReviews", allReviews);
        response.sendRedirect("/ScopeSoftware/Reviews");
    }else {
        Object allReviews = query.getAllReviews();
        request.setAttribute("allReviews", allReviews);

        RequestDispatcher rd = request.getRequestDispatcher("reviews.jsp");
        rd.forward(request, response);
    }   
}