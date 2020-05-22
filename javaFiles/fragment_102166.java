// get the session, add argument `true` to create a session if one is not yet created.
HttpSession session = request.getSession(true);

session.setAttribute("userName", request.getParameter("userName"));
session.setAttribute("password", request.getParameter("password"));

// to get the username and password
String userName = session.getAttribute("userName");
String password = session.getAttribute("password");