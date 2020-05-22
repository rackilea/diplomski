<form name="calcsum" action="PlusServlet" method="POST">
        <% String Number1 = request.getParameter("Number1"); %>
        <% String Number2 = request.getParameter("Number2"); %>
        <br>
        <span>Number1= <%= Number1 %> from calc.jsp form. </span>
        <br>
        <span>Number2= <%= Number2 %> from calc.jsp form. </span>
        <br><br><br><br><br>
        <input type="hidden" value="<%= Number2 %>" name="Number1" />
        <input type="submit" value="Plus-Calc" name="Plus-Calc" />
</form>