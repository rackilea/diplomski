Enumeration en=request.getParameterNames();
String[] values=new String[100];
for(int i=1;en.hasMoreElements();i++)
{
    String param=(String) en.nextElement();
    values[i]=request.getParameter(param);
    [i]=request.getParameter(“param”);
    ps.setString(i,values[i]);           
    ps.executeUpdate();
}