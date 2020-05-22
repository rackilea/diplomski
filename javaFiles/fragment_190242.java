int courseid = Integer.parseInt(request.getParameter("courseid"));
  student thestudent=new student(courseid);
  dbutil.insetcourse(thestudent);
  request.setAttribute("message", "Records loaded successfully");
  RequestDispatcher dispatcher = request.getRequestDispatcher("/course.jsp");
  dispatcher.forward(request,response);