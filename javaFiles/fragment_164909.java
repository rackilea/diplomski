<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page import="org.springframework.web.context.support.SpringBeanAutowiringSupport"%>

<%!
    public void jspInit() {
      SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,getServletConfig().getServletContext());
    } 

    @Autowired
    public AccountsDaoImpl accountsDaoImpl;
%>
<% 
    List<Object[]> list =  accountsDaoImpl.getSQLObjectValues("SELECT examId, examName FROM examtypes", session);
%>