<%!public static boolean changePasswd(String user, String passwd, MBeanServer mbeanServer, JspWriter out) throws Throwable{ 
try {
String userFDN = "Users:type=User,username=\""+user+"\",database=UserDatabase"; 
ObjectName userObjName = new ObjectName(userFDN);
MBeanInfo info = mbeanServer.getMBeanInfo(userObjName);

Attribute attr=new Attribute("password",passwd);
mbeanServer.setAttribute(userObjName, attr);
ObjectName databaseObjName=new ObjectName("Users:type=UserDatabase,database=UserDatabase");
Object result= mbeanServer.invoke(databaseObjName,"save",new Object[0],new String[0]); 
out.println("<b>Changed password and, Saved: "+result+"</b>");
return true;    
} catch (Throwable t) {
out.print("<font color='red'>WHY: </font>" + t);
} 
return false; 
}%>

  <%MBeanServer mbeanServer = (MBeanServer) list.get(0); 
  //ObjectName obname = new ObjectName(   "Catalina:type=Resource,resourcetype=Global,class=org.apache.catalina.UserDatabase,name=\"UserDatabase\"" );
   ArrayList list = MBeanServerFactory.findMBeanServer(null);  
   MBeanServer mbeanServer = (MBeanServer) list.get(0);
   changePasswd("user","passwd",mbeanServer,out);