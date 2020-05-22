for (int i =0;i<friends.length();i++){
          JSONObject friend = friends.getJSONObject(i);
          HashMap<String, String> map = new HashMap<String, String>();
          map.put("steamid", friend.getString("steamid"));
          map.put("relationship", friend.getString("relationship"));
          map.put("friend_since", friend.getString("friend_since"));
        friendsList.add(map);