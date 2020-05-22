public static void main(String[] args) throws ParseException {
    String jsonArray =
            "[" +
                    "{\"previous_id\":33261,\"current_id\":25775,\"user_id\":239,\"timestamp\":\"Dec 11, 2015 2:48:49 AM\",\"visitors_ip_address\":\"169.92.246.239\",\"os_name\":\"iOS\",\"mac_address\":\"e8:21:55:e8:53:97\",\"URL\":\"http://www.quisuc.com\",\"no_of_visitors\":251,\"browser_name\":\"Opera\",\"country\":\"Fiji\",\"state\":\"North Dakota\",\"city\":\"Lakeland\"}," +
                    "{\"previous_id\":16872,\"current_id\":18715,\"user_id\":44,\"timestamp\":\"Aug 4, 2015 8:08:37 AM\",\"visitors_ip_address\":\"24.3.34.149\",\"os_name\":\"Linux\",\"mac_address\":\"f4:2d:ef:c4:ab:cc\",\"URL\":\"http://www.adaptindustries.eu\",\"no_of_visitors\":58,\"browser_name\":\"Opera\",\"country\":\"TurksandCaicosIslands\",\"state\":\"Hawaii\",\"city\":\"Northhaven\"}," +
                    "{\"previous_id\":13598,\"current_id\":28899,\"user_id\":837,\"timestamp\":\"Jan 3, 2015 11:40:35 PM\",\"visitors_ip_address\":\"70.117.219.82\",\"os_name\":\"Cent\",\"mac_address\":\"2e:ea:6b:9e:33:4f\",\"URL\":\"http://www.quicklinkltd.com\",\"no_of_visitors\":966,\"browser_name\":\"Firefox\",\"country\":\"Qatar\",\"state\":\"Georgia\",\"city\":\"Southbury\"}," +
                    "{\"previous_id\":31312,\"current_id\":54746,\"user_id\":989,\"timestamp\":\"Feb 22, 2015 3:16:46 PM\",\"visitors_ip_address\":\"61.164.130.216\",\"os_name\":\"iOS\",\"mac_address\":\"10:5b:92:45:bc:ab\",\"URL\":\"http://www.interdem.biz\",\"no_of_visitors\":72,\"browser_name\":\"Chrome\",\"country\":\"ElSalvador\",\"state\":\"Arkansas\",\"city\":\"Eaststad\"}," +
                    "{\"previous_id\":57367,\"current_id\":99869,\"user_id\":126,\"timestamp\":\"Aug 10, 2015 9:56:16 PM\",\"visitors_ip_address\":\"41.60.118.58\",\"os_name\":\"Unix\",\"mac_address\":\"b8:e0:db:94:d0:9d\",\"URL\":\"http://www.furbainc.com\",\"no_of_visitors\":166,\"browser_name\":\"Internet Explorer\",\"country\":\"Ghana\",\"state\":\"Massachusetts\",\"city\":\"Eastborough\"}," +
                    "{\"previous_id\":71218,\"current_id\":11120,\"user_id\":919,\"timestamp\":\"Oct 15, 2015 7:09:58 AM\",\"visitors_ip_address\":\"170.70.40.8\",\"os_name\":\"iOS\",\"mac_address\":\"a4:24:95:bd:bd:e2\",\"URL\":\"http://www.quisuc.com\",\"no_of_visitors\":550,\"browser_name\":\"Chrome\",\"country\":\"Poland\",\"state\":\"New Hampshire\",\"city\":\"Northstad\"}," +
                    "{\"previous_id\":52971,\"current_id\":84261,\"user_id\":21,\"timestamp\":\"Jun 7, 2015 2:25:02 AM\",\"visitors_ip_address\":\"0.110.96.212\",\"os_name\":\"Linux\",\"mac_address\":\"da:bd:9f:5f:34:79\",\"URL\":\"http://www.quicker.biz\",\"no_of_visitors\":508,\"browser_name\":\"Safari\",\"country\":\"SaintVincentandtheGrenadines\",\"state\":\"Delaware\",\"city\":\"Westside\"}," +
                    "{\"previous_id\":22309,\"current_id\":72904,\"user_id\":701,\"timestamp\":\"Dec 18, 2015 11:36:22 PM\",\"visitors_ip_address\":\"42.233.230.247\",\"os_name\":\"Mac\",\"mac_address\":\"a4:b8:5e:80:c1:60\",\"URL\":\"http://www.felics.biz\",\"no_of_visitors\":994,\"browser_name\":\"Internet Explorer\",\"country\":\"ElSalvador\",\"state\":\"Tennessee\",\"city\":\"Newchester\"}," +
                    "{\"previous_id\":90554,\"current_id\":96910,\"user_id\":330,\"timestamp\":\"Sep 26, 2015 7:42:18 AM\",\"visitors_ip_address\":\"216.197.61.226\",\"os_name\":\"Android\",\"mac_address\":\"42:f6:00:35:08:8a\",\"URL\":\"http://www.morseminc.biz\",\"no_of_visitors\":587,\"browser_name\":\"Opera\",\"country\":\"Guadeloupe\",\"state\":\"Minnesota\",\"city\":\"Lakeland\"}," +
                    "{\"previous_id\":71276,\"current_id\":62107,\"user_id\":603,\"timestamp\":\"Aug 10, 2015 3:42:22 PM\",\"visitors_ip_address\":\"178.246.204.216\",\"os_name\":\"Mac\",\"mac_address\":\"ee:13:d4:5d:bb:a3\",\"URL\":\"http://www.warst.eu\",\"no_of_visitors\":45,\"browser_name\":\"Chrome\",\"country\":\"PitcairnIslands\",\"state\":\"Nevada\",\"city\":\"Eastfurt\"}" +
            "]";
    JsonArray array = (JsonArray) new JsonParser().parse(jsonArray);
    Map<Integer, Map<Integer, JsonArray>> nestedJsonMap = new HashMap<>();
    for (JsonElement element : array) {
        if (element instanceof JsonObject) {
            Date temp = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa").parse(((JsonObject) element).get("timestamp").getAsString());
            int year = temp.getYear() + 1900; // date.getYear() gives you current year - 1900
            int month = temp.getMonth() + 1; // date.getMonth() is 0-indexed, so we have to add 1 to get the normal month
            if (!nestedJsonMap.containsKey(year)) {
                nestedJsonMap.put(year, new HashMap<>());
                nestedJsonMap.get(year).put(month, new JsonArray());
                nestedJsonMap.get(year).get(month).add(element);
            } else {
                if (nestedJsonMap.get(year) == null || !nestedJsonMap.get(year).containsKey(month)) {
                    nestedJsonMap.get(year).put(month, new JsonArray());
                    nestedJsonMap.get(year).get(month).add(element);
                } else {
                    nestedJsonMap.get(year).get(month).add(element);
                }
            }
        }
    }
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String nestedJsonArray = gson.toJson(nestedJsonMap);
    System.out.println(nestedJsonArray);
}