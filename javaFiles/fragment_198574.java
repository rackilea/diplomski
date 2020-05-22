<select>
    <c:forEach begin="0" end="23" var="hour">
         <option value="${hour}">
             <fmt:formatNumber value="${hour}" type="number" minIntegerDigits="2"/>
         </option>
    </c:forEach>
</select>