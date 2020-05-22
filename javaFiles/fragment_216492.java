<% for (Owner owner : ownerList) { 
    // assuming getPenSet() returns set object.
    Set<Pen> pens = owner.getPenSet();
%>
    <!-- Here I am adding rowspan value dynamically, depends no of pens.
     Adding `+1` to no of pens because the Owner is also counted for the rowspan. -->
    <tr><td rowspan="<%=pens.size()+1>"><%=owner.getOname()%></td> </tr>

        <% for (Pen pen : pens) { %>
        <tr>
            <td><%=pen.getPbrand()%></td>
            <td><%=pen.getPcolour()%></td>
        </tr>
        <% }
       // no need of <br> inside of `<table>`
       // out.print("</br>");
    }