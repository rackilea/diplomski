// check the credentials
boolean loggedIn = verify(username, password);

// store the result in a request attribute, so that the JSP can retrieve it
request.setAttribute("loggedIn", loggedIn);

// let a JSP display the result
request.getRequestDispatcher("/loginResult.jsp").forward(request, response);