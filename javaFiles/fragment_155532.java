String searchResponseJSON = API.search(term, location);

JSONParser parser = new JSONParser();
JSONObject response = null;
try {
    response = (JSONObject) parser.parse(searchResponseJSON);
} catch (ParseException pe) {
    System.out.println("Error: could not parse JSON response:");
    System.out.println(searchResponseJSON);
    System.exit(1);
}");