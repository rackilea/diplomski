<table style="text-align: left; width: 100%; height: 172px;" border="0" cellpadding="0" cellspacing="0">
    <tbody>
        <tr>
            <td colspan="1" rowspan="6" style="vertical-align: top;">product_gallery<br></td>
            <td colspan="1" rowspan="6" style="vertical-align: top;"><img class="img" src="${initParam.productBigImagePath}${selectedProduct.name}.jpg"><br></td>
            <td style="vertical-align: top;">${selectedProduct.name}<br></td>
            <td style="vertical-align: top;"><br></td>
        </tr>
        <tr>
            <td style="vertical-align: top;">$ ${selectedProduct.price}</td>
            <td style="vertical-align: top;"><br></td>
        </tr>
        <tr>
            <td style="vertical-align: top;"><br></td>
            <td style="vertical-align: top;"><br></td>
        </tr>
        <tr>
            <td style="vertical-align: top;"><br></td>
            <td style="vertical-align: top;"><br></td>
        </tr>
        <tr>
            <td colspan="2" rowspan="1" style="vertical-align: top;">${selectedProduct.description}</td>
        </tr>
        <tr>
            <td style="vertical-align: top;">
                <form action="addToWishlist" method="post"><br><br> 
                    <input name="productId" value="${selectedProduct.id}" type="hidden"> 
                    <input class="submit" value="<fmt:message key='AddToWishlist'/>" type="submit"> 
                </form><br>
            </td>
            <td style="vertical-align: top;">
                <form action="addToCart" method="post"><br><br> 
                    <input name="productId" value="${selectedProduct.id}" type="hidden">
                    <input class="submit" value="<fmt:message key='AddToCart'/>"type="submit"> 
                </form>
            </td>
        </tr>
        <tr>
            <td style="vertical-align: top;"><br></td>
            <td style="vertical-align: top;"><br></td>
            <td colspan="2" rowspan="1" style="vertical-align: top;">
                <ul>
                    <li style="background-color: rgb(198, 255, 201); width:100%; text-align:center; border-radius:2em;">
                        <a href="${value}"><fmt:message key='ContinueShopping'/></a>
                    </li>
                </ul>
                <br>
            </td>
        </tr>
    </tbody>
</table>