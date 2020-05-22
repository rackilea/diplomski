<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <%
        Map myMap = new HashMap();
        pageContext.setAttribute("theMap", myMap);
    %>
    <c:set target="${theMap}" property="aKey" value="value for a key" />
    <c:set target="${theMap}" property="otherKey" value="value for other key" />

    Map content: ${theMap}
</html>