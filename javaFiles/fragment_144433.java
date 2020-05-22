JSONArray rooms = jsonObject.getJSONArray("rooms");
     for (int i = 0; i < rooms.length(); i++) {
        JSONObject room = rooms.getJSONObject(i);
       String name = room.optString("room");
       String roomid = room.optString("roomid");
      final RoomModel sched = new RoomModel();
       sched.setName(name);
       sched.setroomId(roomid);
    CustomListViewValuesArr.add(sched);}        
listView = (ListView) findViewById(R.id.ChatlistView);
MyAdapter adapter=new MyAdapter(this,CustomListViewValuesArr);
listView.setAdapter(adapter);