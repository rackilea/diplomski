<%-- tpl:metadata --%>
<%-- jsf:pagecode language="java" location="/src/pagecode/menu/Main.java" --%><%-- /jsf:pagecode --%>
<%-- /tpl:metadata --%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" media="screen" href="theme/menu.css">
<link rel="stylesheet" type="text/css" href="theme/stylesheet.css" title="Style">

    <% String Page = (session.getAttribute("mainPage") == null) ? "1" : (String)session.getAttribute("mainPage"); %>

    <h:form id="formMenu" styleClass="form">
        <ul id="tabmenu">
            <li<%= (Page.compareTo("1") == 0) ? " class=active" : ""%>><h:commandLink id="link1" action="#{pc_Main.doLink1Action}"><h:outputText id="textMenu1" styleClass="outputText" value="Credit/Gift Card Request"></h:outputText></h:commandLink></li>
            <li<%= (Page.compareTo("2") == 0) ? " class=active" : ""%>><h:commandLink id="link2" action="#{pc_Main.doLink2Action}"><h:outputText id="textMenu2" styleClass="outputText" value="My Requests"></h:outputText></h:commandLink></li>
            <li<%= (Page.compareTo("3") == 0) ? " class=active" : ""%>><h:commandLink id="link3" action="#{pc_Main.doLink3Action}"><h:outputText id="textMenu3" styleClass="outputText" value="My ToDo's"></h:outputText></h:commandLink></li>
            <li<%= (Page.compareTo("5") == 0) ? " class=active" : ""%>><h:commandLink id="link5" action="#{pc_Main.doLink5Action}"><h:outputText id="textMenu5" styleClass="outputText" value="Search"></h:outputText></h:commandLink></li>
            <% if (request.isUserInRole("giftAdmin") | request.isUserInRole("giftAdminBackup") | request.isUserInRole("merchAdmin") | request.isUserInRole("merchAdminBackup")){ %>
            <li <%= (Page.compareTo("4") == 0) ? " class=active" : ""%>><h:commandLink
                id="link4" action="#{pc_Main.doLink4Action}">
                <h:outputText id="textMenu4" styleClass="outputText"
                    value="Accounting"></h:outputText>
            </h:commandLink></li>
            <li><a href="<%= request.getContextPath() %>/forms/Help.pdf" target="_blank">Help</a></li>
            <% } %>
        </ul>
    </h:form>