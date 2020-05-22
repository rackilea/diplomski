<style type="text/css">
    .excel_data_value_string{   
    mso-number-format:"\@";
}
</style>

<c:forEach var="object" items="${objectList}">
    <td class="excel_data_value_string">
        <c:out value="${object.value}"/>
    </td>
</c:forEach>