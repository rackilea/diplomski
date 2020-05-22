Object obj = parser.parse(new FileReader("C:\\Users\\User\\Desktop\\test2.json"));

JSONObject jsonObject = (JSONObject) obj;
JSONObject forecast = jsonObject.get("forecast");
JSONObject txt__forecast = jsonObject.get("txt_forecast");
JSONArray forecastday = jsonObject.getJSONArray("forecastday");
JSONObject forecastIdx0 = forecastday.get(0);
int period = forecastIdx0.getInt("period");
Stting title = forecastIdx0.getString("title");