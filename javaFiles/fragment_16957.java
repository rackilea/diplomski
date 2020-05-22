<c:forEach items="${AllReceipes}" var="receipt">
        <tr>
            <td>${receipt.nombreReceta}</td>
            <td>${receipt.catidadIngredientes}</td>
            <td>${receipt.ingredientes}</td>
            <td>${receipt.modoPreparacion}</td>
            <td>${receipt.calorias}</td>
            <td>${receipt.tiempo}</td>
            <td>${receipt.dificultad}</td>
        </tr>
    </c:forEach>