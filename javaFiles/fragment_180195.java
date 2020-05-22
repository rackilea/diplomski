<c:forEach="${prodList}" var="product">
 <tr>
        <td><c:out value="${product.productID}"/></td>
        <td><c:out value="${product.productName}"/></td>
        <td><c:out value="${product.productType}"/></td>
        <td><c:out value="${product.productDiscription}"/></td>
        <td><c:out value="${product.productPrice}"/></td>
        <td><c:out value="${product.productSize}"/></td>
        <td><img src="<c:out value="${product.productPicURL}"/>" style="width:304px;height:228px;"></td>
  </tr>
</c:forEach>