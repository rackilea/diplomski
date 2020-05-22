<tr> 
<td width="17%" class=label > <b>Place of Birth</b>&nbsp; </td>
<td colspan="3" class=value> <div align="left"> <%=HtmlUtil.setListOptions("birthPlace","onchange ='javascript:SetEnabled()'",birth_place_option,birth_place_code,true,"")%> 
    if others, please specify remarks
<c:choose>
    <c:when test="${birth_place_code != null && birth_place_code == '99'}">
        <c:when test="${other_place_birth!=null}">
            <input type="text" size=41 maxlength=66 name="birthPlaceT" value="<c:out value="${other_place_birth}"/>">        
        </c:when>
        <c:otherwise>
            <input type="text" size=41 maxlength=66 name="birthPlaceT" value="">           
        </c:otherwise>
    </c:when>
    <c:otherwise>
    <input type="text" size=41 maxlength=66 name="birthPlaceT" value=" " disabled>
    </c:otherwise>
</c:choose>
  </div></td>