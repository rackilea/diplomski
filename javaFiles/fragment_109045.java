String valido="0";
try {

if (allowUser(userName, passWord,login.getDbUsr())) {
session = request.getSession();
valido="1";
session.setAttribute("logon.isDone", userName);
if ((UsersRegistados.getUsers().containsKey(
request.getRequestedSessionId()) ||   UsersRegistados.getUsers().containsValue(userName))) {
System.out.println("user already registered");
                            }
                        else{
                        UsersRegistados.setUsers(session.getId(), userName);
                        login.setFile(DB.toLowerCase()+"pp"); //crmpp file
                        login.setUcode(userCode); // ep_code
                        login.setUsername(userName); //epName
                        login.setUserType(userType);
                        login.setIdiom(language); 
                        login.setPassword(passWord);
                        login.setSession_id(session.getId());
                         //Try redirecting the client to the page he first tried to access
                         session.setAttribute("login", login); 
                         session.setAttribute("language", language.toUpperCase());
                        }
                   //response.sendRedirect(request.getRequestURI().substring(0,request.getRequestU    RI().indexOf('/', 1))+"/Calendar/calendar.jsp");
//response.setStatus(response.SC_MOVED_TEMPORARILY);
//response.setHeader("Location",  "Calendar/calendar.jsp");
//System.out.println(jsonResponse);
                    }


                    System.out.println(login.getSession_id());
                    StringBuilder jsonStr = new StringBuilder();
                    jsonStr.append("{'redirect':'" + (request.getRequestURI().substring(0,request.getRequestURI().indexOf('/', 1))+"/Calendar/calendar.jsp") +"','valido':'"+valido+"'}");
                    jsonResponse = jsonStr.toString().replaceAll("'",
                            Character.toString((char) 34));
                    try {
                        out.println(jsonResponse);
                        out.flush();
                    } finally {
                        out.close();                    
 //response.sendRedirect(request.getRequestURI().substring(0,request.getRequestURI().indexOf('/', 1))+"/Calendar/calendar.jsp");
//return;
}
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}