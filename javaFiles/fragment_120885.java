//Obtain the session object, create a new session if doesn't exist
HttpSession session = request.getSession(true);

//set a string session attribute
session.setAttribute("MySessionVariable", "MySessionAtrValue");

//get a string sessson attribute
String strParam = session.getAttribute("MySessionVariable");


//get an integer sessioin attribute
Integer param = (Integer) session.getAttribute("MySessionVariable");

//set an integer session attribute
session.setAttribute("MySessionVariable", new Integer(param.intValue() + 1));