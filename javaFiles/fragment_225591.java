private void populateMessages(JSONObject msgObj) {
        messages = ChatMessage.fromJson(msgObj);
        mAdapter.clear();
        mAdapter.addAll(messages);
        mListView.invalidateViews();
        mAdapter.notifyDataSetChanged();        
   }


public static ArrayList<ChatMessage> fromJson(JSONObject jsonObject) {
  ArrayList<ChatMessage> messages = new ArrayList<>();
  try {
    JSONArray items = jsonObject.getJSONArray("messages");
    for (int i = 0; i < items.length(); i++) {
       ChatMessage msg = new ChatMessage();
       ....
       ....
       messages.add(msg);
    }
  }

 return messages;
}