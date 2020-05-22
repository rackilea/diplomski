List<String> countries = new ArrayList<String>();
String json = "[\"england\",\"france\",\"germany\",\"america\"," +
        "\"denmark\",\"italey\",\"greece\",\"portugal\",\"poland\"]";

JSONArray countryArr = new JSONArray(json);
for (int i = 0; i < countryArr.length(); i++) {
    countries.add(countryArr.getString(i));
}
System.out.println(countries);