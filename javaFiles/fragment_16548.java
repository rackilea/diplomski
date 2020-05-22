<c:choose>
            <c:when test="${param.chk==true}">
                Checked <input type="checkbox" name="dance"
                       checked/>
            </c:when>
            <c:otherwise>
                Unchecked <input type="checkbox" name="dance"
                       />
            </c:otherwise>
        </c:choose>