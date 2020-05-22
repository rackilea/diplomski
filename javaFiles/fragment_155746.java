MakeHTTPRequest makeHTTPRequest = new MakeHTTPRequest();
    String response = "";
    String apiKey = MY_KEY; //Set your Android Key here

    String query = "";
    // input = input.replace(",","+");
    if(input.contains(" "))
        query = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%22"+input.replace(" ","+")+"%22&type=video&key="+apiKey;
    else
        query = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%22="+input+"%22&type=video&key="+apiKey;
    try {
        response = makeHTTPRequest.sendGet(query);
    }
    catch (Exception e){
        e.printStackTrace();
    }

    System.out.println("Youtube results : "+response);

    JSONObject responseJSON= null;
    try {
        responseJSON = new JSONObject(response);

        JSONArray items = responseJSON.getJSONArray("items");


        for(int i=0;i<items.length();i++){
            System.out.println("Item "+i+" : ");
            System.out.println("Title : "+items.getJSONObject(i).getJSONObject("snippet").get("title"));
            System.out.println("Description : "+items.getJSONObject(i).getJSONObject("snippet").get("description"));
            System.out.println("URL : https://www.youtube.com/watch?v="+items.getJSONObject(i).getJSONObject("id").getString("videoId"));



        }
    } catch (JSONException e) {
        e.printStackTrace();
    }