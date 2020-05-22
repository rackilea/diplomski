<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("interestEarnList", Arrays.asList(11,22,33,44,55));
    request.setAttribute("numYear", Arrays.asList(1,2,3,4,5));
    request.setAttribute("endBalanceList", Arrays.asList(122,244,366,488,610));
    request.setAttribute("startBalanceList", Arrays.asList(111,222,333,444,555));
%>
    <c:forEach var="year" items="${numYear}" varStatus="status">
        Year Number: ${year}, <br/>
        Beginning Balance of this year is: ${startBalanceList[status.index]},<br/>
        Ending Balance of this year is: ${endBalanceList[status.index]},<br/>
        Total interest earned this year: ${interestEarnList[status.index]}<br/>
    </c:forEach>