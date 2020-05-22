<c:choose>
        <c:when test="${sessionScope.discountAdded == 'true'}">
            <p align="center">  
                All Discount(s) added successfully!     
            </p>
        </c:when>
        <c:otherwise>
            <p align="center">
                Error Found! No Discounts added!
            </p>
        </c:otherwise>
    </c:choose>