<%@include file = "globalFunctions.jsp" %>

        <% Boolean submitted = Boolean.parseBoolean(request.getParameter("isSubmitted"));
           double we = 0, he = 0;
           if(submitted){
               weight = Double.parseDouble(request.getParameter("w"));
               height = Double.parseDouble(request.getParameter("h"));
               bmi = calcBMI(we, he);
               classification = calcClassif(bmi);
           }
        %>

        <h3>BMI Calculator</h3>

        <form action = "index.jsp" method = "post">
            <input type ="hidden" name = "isSubmitted" value = "true"> 
            Weight: <input type = "text" name = "w"> <br> <br>
            Height: <input type = "text" name = "h"> <br> <br>
            <input type = "submit" value = "Compute"> <br> <br>

            BMI: <%= bmi %> <br> <br>
            Classification: <%= classification %>
    </form>