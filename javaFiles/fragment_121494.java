<!-- START DUMPING DATA -->
<% 
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products"); 

    for(Product product : products)
    {%>
      <tr>
        <td>product.getProduct()</td>
        <td>product.getCompany()</td>
        <td>product.getCName()</td>
        <td>product.getValidity()</td>
        <td>product.getUnit()</td>
        <td>product.getTotPrice()</td>
      </tr>
    %>