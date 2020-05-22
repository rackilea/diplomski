<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <div>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td><c:out value="${product.name}" /></td>
                        <td><c:out value="${product.description}" /></td>
                        <td><c:out  value="${product.price}" /></td>
                    </tr>
                </c:forEach>
            </div>
        </table>
        <br/><br/>
        <form  id="form1" action="YourProductsServlet" method="post">
            <table> 
                <tr> <td>Product Name : <input type="text" name="pname" id="pname" /></td></tr>
                <tr> <td>Product Description : <input type="text" name="pdesc" id="pdesc"/></td></tr>
                <tr><td>Product Price : <input type="text" name="price" id="price"/></td></tr>
                <tr><td> <input type="submit" value="save"/></td></tr>

            </table>
            <div style="color: red" id="result"></div>
        </form> 
        <script>
    //ajaxifying an existing form
    $(document).on("submit", "#form1", function(event) {
       var $form = $(this);
       $.post($form.attr("action"), $form.serialize(), function(responseJson) {
        // handle response data 

   var $table = $("<table>").appendTo($("#result")); // Create HTML <table> element and append it to HTML DOM element with ID "result".
        $.each(responseJson, function(index, product) {    // Iterate over the JSON array.
            $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
                .append($("<td>").text(product.id))        // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
                .append($("<td>").text(product.name))      // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
                .append($("<td>").text(product.price));    // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
        });

       });    
       event.preventDefault(); // Important! Prevents submitting the form.
    });
        </script>
    </body>
</html>