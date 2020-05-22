Integer varsta = null;
String varstaStr = request.getParameter("varsta"); // read string 'varsta' field
try {
    varsta = Integer.parseInt(varsta);
} catch (NumberFormatException e) {
    // handle error
}