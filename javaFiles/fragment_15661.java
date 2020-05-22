<%@page contentType="text/plain"%>
<%

// get the input values
double val1 = 0;
double val2 = 0;
String errorMsg = "";
try {
    val1 = Double.parseDouble(request.getParameter("val1"));
    val2 = Double.parseDouble(request.getParameter("val2"));
} catch (Exception e) {
    errorMsg = "Non-numeric input";
}

// return the javascript object literal
String result = "({";
result += " val1 : " + val1 + ",";
result += " val2 : " + val2 + ",";
result += " sum : " + (val1 + val2) + ",";
result += " difference : " + (val1 - val2) + ",";
result += " product : " + (val1 * val2) + ",";
result += " quotient : " + (val1 / val2) + ",";
result += " errorMsg : \"" + errorMsg + "\"";
result += "})";
out.println(result);
%>