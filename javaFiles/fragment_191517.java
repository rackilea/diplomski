public String get_fixtures_between_dates() throws Exception {
    String DATE_FORMAT;
    DATE_FORMAT = "YYYY-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance(); // today
    String todays_date = sdf.format(c1.getTime());

    String DATE_FORMAT1 = "YYYY-MM-dd";
    SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT1);
    Calendar c2 = Calendar.getInstance(); // today
    c2.add(Calendar.DATE, 1);
    String tomorrows_date = sdf1.format(c2.getTime());

    Map<String, String> additional_parameters = new HashMap<>();

    responseBody = call.getFixtureId(todays_date, tomorrows_date).execute();
    String response_body_string = responseBody.body().string();
    String[] tmp = response_body_string.split(",");
    String val1 = tmp[0];
    tmp = tmp[1].split(",");
    //Returns second game ID
    String val2 = tmp[0];
    System.out.println(val2);

return val2
}