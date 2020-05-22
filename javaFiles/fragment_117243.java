<table align="center" style="position: relative; left: 0px; top: -20px; width: 100%">
  <tr>
   <td width="40%" class="">
    <form:label path="user">Username: </form:label></td>
   <td width="60%" class="">
    <form:input path="usuario" cssClass="" readonly="true"/></td>
  </tr>
    <form:hidden path="password" id="pwdDB" />
  <tr>
   <td width="40%" class="">
    <form:label path="password">Password: </form:label></td>
   <td width="60%" class=""><form:password path="" id="password" cssClass="" maxlength="14"/></td>
  </tr>
  <tr>
   <td colspan="2"><form:hidden path="username" /></td>
  </tr>
  <tr>
   <td colspan="2"><form:hidden path="otherattributePOJO" /></td>
  </tr>
  <tr>
   <td colspan="2"><form:hidden path="anotherattributePOJO" /></td>
  </tr>
</table>