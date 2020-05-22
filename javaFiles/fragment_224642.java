<c:forEach var="element" items="${requestScope['listData']}" varStatus="status">
            <tr>
                <td><input  name="typeId${status.index}" value="${element.typeId}" readonly="true"</td>
                <td><input  name="paramSeq${status.index}" value="${element.paramSeq}" readonly="true"</td>
                <td><input  name="paramName${status.index}" value="${element.paramName}" readonly="true"</td>
                <td>
                    <input id="edit${status.index}" type="button" value="Edit" name="edit" onclick="validate(${status.index})"</input>
                </td>
                <td><input type="checkbox" id="check${status.index}" name="selectedItems" value="<c:out value="${status.index}"/>"</td>
            </tr> 
        </c:forEach>
    </table>