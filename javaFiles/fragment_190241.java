private void insertcourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

    // Assuming you are getting multiple courseid in your request, 
    Object[] courseid = request.getParameter("courseid");
    for(Object obj : courseid)
    {
          student thestudent=new student(courseid);
           dbutil.insetcourse(thestudent);
     }
    request.setAttribute("message", "Records loaded successfully");
 RequestDispatcher dispatcher = request.getRequestDispatcher("/course.jsp");
dispatcher.forward(request,response);


}