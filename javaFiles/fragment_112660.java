DepartmentBean departmentBean = new DepartmentBean();
UserBean user = new UserBean();
String userName = request.getParameter("username");
String password = request.getParameter("password");


user.setPassowrd(password);
user.setUsername(userName);
departmentBean.addIfAbsent(user);

if(departmentBean.flag == 2)
{

    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
    write(departmentBean);//write to xml

}