<% 
    //set new parameters to be passed through to the jsp:include
    request.setAttribute("objectName", objectInstance);
%>
    <jsp:include page="/includes/requisitionClinicalConditionContent.jsp"/>
<%
    //get parameters passed from the jsp:include
    objectInstance = (object) request.getAttribute("objectName");
%>