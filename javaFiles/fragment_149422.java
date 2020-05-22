public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("http://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v0001/?key="+key+"&steamid=76561198170248415&format=json");
    System.out.println(json.toString());

    JSONObject response = json.getJSONObject("response"); //you get response, it's Json Object 
    int totalCount = response.getInt("total_count");   //total_count, it's name/value pair total_count/5
    JSONArray games = response.getJSONArray("games");  //games, it's Json Array

    System.out.println("Games total: " + totalCount);

    for(int i = 0; i < games.length(); i++){  //we're iterating through the array of Json Objects
        JSONObject game = games.getJSONObject(i); //every game is Json Object

        int appId = game.getInt("appid");   //in every game we have 5 key/value pairs appid/730, etc...
        String name = game.getString("name");  
        int playtime2weeks = game.getInt("playtime_2weeks");
        int playtimeForever = game.getInt("playtime_forever");
        String imgIconUrl = game.getString("img_icon_url");
        String imgLogoUrl = game.getString("img_logo_url");

        System.out.println("appid: " + appId + " name: " + name + " playtime2weeks: " + playtime2weeks + " playtime_forever: " + playtimeForever);
    }