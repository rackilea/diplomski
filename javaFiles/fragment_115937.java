<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="${clues}" var = "clue">
    <tr>
    <td>${clue.weibo.user.name}</td>
    <td>
    ${fn:substring(clue.weibo.text, 0, 10)}
    </td>
    </tr>
</c:forEach>