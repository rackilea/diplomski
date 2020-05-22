<thbody>
 <td>
  <th:block th:each="p: ${AllPermissions}">
   <input type="checkbox" name="perms" th:value="${p.id}" 
 th:checked="${#maps.containsKey(AllowedPermissionsForRole, p.id)}" /> <label th:text="${p.permissionsName}"></label>
  </th:block>
 </td>
</thbody>