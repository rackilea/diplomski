response.setContentType("application/json");
String country = request.getParameter("country");
String continent = request.getParameter("continent");
String region = request.getParameter("region");
int population = Integer.parseInt(request.getParameter("population"));
String capital = request.getParameter("capital");
String returnMessage;
if (Countries.addCountry(country, continent, region, population, capital)) {
    returnMessage = "Record Inserted.";
} else {
    returnMessage = "Unable to Insert Record.";
    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    try {
        throw new InsertException("Unable to Insert record");
    } catch (InsertException ex) {
        log.debug(ex.getMessage());
    }
}
new Gson().toJson(returnMessage, response.getWriter());