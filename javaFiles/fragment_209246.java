<c:forEach var="row" items="${result.rowsByIndex}"> 
    <form action="/runthis/servlet" method="post">
        <input type="hidden" name="id" value="<c:out value="${row[1]}"/>" />
        <input type="hidden" name="EmployeeName_orig" value="<c:out value="${row[2]}"/>" />
        Employee Name<input type="text" name="EmployeeName" value="<c:out value="${row[2]}"/>" />
        <input type="hidden" name="Department_orig" value="<c:out value="${row[4]}"/>" />
        Department
        <select id="Department" name="Department">
            <option value="<c:out value="${row[4]}"/>"><c:out value="${row[4]}"/></option>
        </select>
        <input type="submit" value="Save" />
    </form>
</c:forEach>