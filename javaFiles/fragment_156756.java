private void updatePlaylist() {
    JSONObject json = createJSONPlaylist("updated title", 10001, 10002);
    HttpResponse resp = api.put(Request.to("/playlists/123")                     
        .withContent(json.toString(), "application/json"));
}

private JSONObject createJSONPlaylist(String title, long... trackIds) throws JSONException { 
    JSONObject playlist = new JSONObject();                                                  
    playlist.put("title", title);                                                            

    JSONObject json = new JSONObject();                                                      
    json.put("playlist", playlist);                                                          

    JSONArray tracks = new JSONArray();                                                      
    playlist.put("tracks", tracks);                                                          

    for (long id : trackIds) {                                                               
        JSONObject track = new JSONObject();                                                 
        track.put("id", id);                                                                 
        tracks.put(track);                                                                   
    }                                                                                        
    return json;                                                                             
}