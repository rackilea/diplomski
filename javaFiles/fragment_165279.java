<c:forEach var="result" items="${resultList}">
    <tr>
    <td class="td-highlighted-2">
     <div align="left"><a href="UpdateProject.html">${result.projId}</a></div>
    </td>
    <td class="td-highlighted-2">
      <div align="left">${result.projname}</div>
    </td>
    <td class="td-highlighted-2">
      <div align="left">${result.cost}</div>
    </td>
    <td class="td-highlighted-2">
      <div align="left">${result.manager}</div>
    </td>
    </tr>
</c:forEach>