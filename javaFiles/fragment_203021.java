<c:forEach items="${list}" var="item">  
    <tr>  
        <td align="center">  
            <input type="checkbox" name="selectedItems"   
                value="<c:out value="${item.numberPlate}"/>"/>  
        </td>
        <td align="left"><c:out value="${item.numberPlate}"/></td>  
        <td align="left"><c:out value="${item.driver.fullName}" /></td>  
        <td align="left"><input type="text" name="mileage_<c:out value="${item.numberPlate}"/>" value="" /></td>  
    </tr>  
</c:forEach>