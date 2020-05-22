<c:forEach items="${clients}" var="client" varStatus="loop">  
    <tr>  
       <td align="center"><c:out value="${loop.index}" /></td>  
       <td><c:out value="${client.nomPrenom}"/></td>  
    </tr>
</ c:forEach>