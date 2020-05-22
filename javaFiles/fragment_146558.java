<% 
    String id ="T";int i=0;
    for(Product p : prodList)
    {           
                %>
        <tr >
          <td width="226" rowspan="3" ><img src="product_images/<%=p.getpImage() %>" width="100px" height="100px" alt="No Image" /></td>
          <td colspan="7" ><%= p.getpName() %><a onclick="removeProductById(<%= p.getpId()%>);" title="Remove From Cart" > <img alt="" src="images/delete.png" height="25px" width="25px"></a></td>
          </tr>
        <tr style="height: 28px;">
          <td colspan="6" ><div align="right"><%=p.getpPrice() %>0 &nbsp;&nbsp;&nbsp; x &nbsp;&nbsp;&nbsp; </div></td> 
          <td style="border-left:0px;"> <input type="text" value="<%=p.getQty() %>"  id="<%=id+i%>" name="txtqty"><a onclick="updateProductById(<%= p.getpId() %>,updateqty('<%=id+i%>'));" href="#"  title="Update Quantity"> <img alt="Updt" src="images/updatecart.png" height="25px" width="25px"> </a></td>
          </tr>
        <tr style="height: 28px;">
          <td colspan="7" style="padding-right: 10px;font-size:15px;"><div align="center">Sub Total : &nbsp;&nbsp;<%=p.getQty() * p.getpPrice() %>0</div></td>

          <% totalbill= totalbill +  p.getQty() * p.getpPrice();%>
          </tr>             
        <% 
        i++;                     
    }
%>